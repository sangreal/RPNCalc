package com.martyn.ops;

import com.martyn.ErrType;
import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class UndoOperatorExecutor implements IOperatorExecuctor {
    @Override
    public boolean isValidOp(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) {
        return queueList != null
                && queueList.size() > 0;
    }

    @Override
    public void execute(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException {
        if (isValidOp(opType, queueList)) {
            queueList.pollLast();
        } else {
            throw new RpnException(ErrType.STACK_ERROR, "stack size is wrong");
        }
    }
}
