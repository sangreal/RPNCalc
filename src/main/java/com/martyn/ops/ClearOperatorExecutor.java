package com.martyn.ops;

import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class ClearOperatorExecutor implements IOpratorExecuctor {
    @Override
    public boolean isValidOp(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        return queueList != null;
    }

    @Override
    public void execute(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        if (isValidOp(opType, queueList)) {
            queueList.offerLast(new ConcurrentLinkedDeque<>());
        } else {
            throw new RpnException("");
        }
    }
}
