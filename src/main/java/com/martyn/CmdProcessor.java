package com.martyn;

import com.martyn.ops.NumExecutor;
import com.martyn.ops.OperatorExecutorFactory;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class CmdProcessor {

    private ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList;

    public CmdProcessor(ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) {
        this.queueList = queueList;
    }

    public void process(String ch) throws RpnException {
        if (Utils.isNumber(ch)) {
            NumExecutor.execute(ch, queueList);
        } else if (Utils.isOperators(ch)) {
            operatorExecute(ch);
        }
    }

    public void operatorExecute(String op) throws RpnException {
        Optional.ofNullable(OperatorExecutorFactory
                .getInstance()
                .getExecutor(op))
                .orElseThrow(() -> new RpnException(""))
                .execute(op, queueList);
    }

}
