package com.martyn.ops;

/**
 * Created by martyn on 18-6-17.
 */
public enum OpType {
    ADD("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("sqrt"),
    UNDO("undo"),
    CLEAR("clear");

    private String value;

    OpType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public static OpType from(String value) {
        for (OpType op : OpType.values()) {
            if (op.value.equalsIgnoreCase(value)) return op;
        }
        return null;
    }

}
