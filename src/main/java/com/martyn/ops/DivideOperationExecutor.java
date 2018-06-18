package com.martyn.ops;

import com.martyn.ErrType;
import com.martyn.RpnException;

/**
 * Created by martyn on 18-6-17.
 */
public class DivideOperationExecutor extends AbstractOperatorExecutor {
    @Override
    public double calcValue(double s1, double s2) throws RpnException {
        if (s1 == 0) throw new RpnException(ErrType.INVALID_DIVIDE, "You cannot divide by zero!!");
        return s2 / s1;

    }
}
