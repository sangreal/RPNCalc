package com.martyn.ops;

import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class SqrtOperationExecutor implements IOpratorExecuctor {
    @Override
    public boolean isValidOp(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        return queueList != null
                && queueList.size() > 0
                && queueList.peekLast().size() > 0;
    }

    @Override
    public void execute(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        ConcurrentLinkedDeque<Double> curQueue = new ConcurrentLinkedDeque<>(queueList.peekLast());
        double s = curQueue.pollLast();
        curQueue.offerLast(Math.sqrt(s));
        queueList.offerLast(curQueue);
    }
}
