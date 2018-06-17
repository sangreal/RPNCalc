package com.martyn.ops;

import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public interface IOpratorExecuctor {
    boolean isValidOp(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException;

    void execute(String opType, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) throws RpnException;
}
