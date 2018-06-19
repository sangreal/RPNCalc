package com.martyn.ops;

import com.martyn.ErrType;
import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public abstract class AbstractOperatorExecutor implements IOperatorExecuctor {
    @Override
    public boolean isValidOp(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) {
        return queueList != null
                && queueList.size() > 0
                && queueList.peekLast().size() > 1;
    }

    @Override
    public void execute(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        if (isValidOp(opType, queueList)) {
            ConcurrentLinkedDeque<Double> curQueue = new ConcurrentLinkedDeque(queueList.peekLast());
            double s1 = curQueue.pollLast();
            double s2 = curQueue.pollLast();
            double result = calcValue(s1, s2);
            curQueue.offerLast(result);
            queueList.offerLast(curQueue);
        } else {
            throw new RpnException(ErrType.INSUFFIENT_PARAMETER,
                    String.format("operator %s (position: %d): insufficient parameters", opType, queueList.size()));
        }
    }

    public abstract double calcValue(double s1, double s2) throws RpnException;
}
