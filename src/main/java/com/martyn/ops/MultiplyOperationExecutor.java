package com.martyn.ops;

/**
 * Created by martyn on 18-6-17.
 */
public class MultiplyOperationExecutor extends AbstractOperatorExecutor {
    @Override
    public double calcValue(double s1, double s2) {
        return s1 * s2;
    }
}
