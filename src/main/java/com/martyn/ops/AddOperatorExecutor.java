package com.martyn.ops;

import com.martyn.RpnException;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class AddOperatorExecutor extends AbstractOperatorExecutor {
    @Override
    public double calcValue(double s1, double s2) {
        return s1 + s2;
    }
}
