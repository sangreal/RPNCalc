package com.martyn;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by martyn on 18-6-17.
 */
public class RPNCalculator {

    // use two doublelinkedlist to record evey state of the stack for undo
    private ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList = new ConcurrentLinkedDeque<>();

    private CmdProcessor cmdProcessor;

    private AtomicBoolean canRunning;

    public RPNCalculator() {
        cmdProcessor = new CmdProcessor(queueList);
        canRunning = new AtomicBoolean(true);
    }

    public void processCmd(List<String> cmdList) {
        if (!canRunning.get()) return;

        try {
            for (String cmd : cmdList) {
                cmdProcessor.process(cmd);
            }
            if (queueList.size() > 0) {
                StackPrinter.print(queueList.peekLast());
            }
        } catch (RpnException e) {
            canRunning.set(false);
            System.out.println(e);
            StackPrinter.print(queueList.peekLast());
            System.out.println("There is error occurred, no input will be accepted");
        }
    }
}
