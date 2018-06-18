package com.martyn;

/**
 * Created by martyn on 18-6-17.
 */
public class RpnException extends Exception {
    private ErrType errType;
    private String payLoad;

    public RpnException(ErrType errType, String payLoad) {
        this(payLoad);
        this.errType = errType;
        this.payLoad = payLoad;
    }

    public RpnException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return payLoad;
    }
}
