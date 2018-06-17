package com.martyn.ops;

import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class MinusOperationExecutor extends AbstractOperatorExecutor {
    @Override
    public double calcValue(double s1, double s2) {
        return s2 - s1;
    }
}
