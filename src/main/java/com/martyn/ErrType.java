package com.martyn;

/**
 * Created by martyn on 18-6-18.
 */
public enum ErrType {
    INVALID_DIVIDE(0),
    INSUFFIENT_PARAMETER(1),
    STACK_ERROR(2),
    INVALID_OPERATOR(3);


    private int value;

    ErrType(int value) {
        this.value = value;
    }
}
