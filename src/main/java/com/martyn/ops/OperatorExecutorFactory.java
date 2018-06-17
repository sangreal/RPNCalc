package com.martyn.ops;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by martyn on 18-6-17.
 */
public class OperatorExecutorFactory {
    private static final OperatorExecutorFactory instance = new OperatorExecutorFactory();

    public static OperatorExecutorFactory getInstance() {
        return instance;
    }

    private OperatorExecutorFactory() {}

    private static Map<String, IOpratorExecuctor> execuctorMap = ImmutableMap.<String, IOpratorExecuctor>builder()
            .put(OpType.ADD.getValue(), new AddOperatorExecutor())
            .put(OpType.MINUS.getValue(), new MinusOperationExecutor())
            .put(OpType.MULTIPLY.getValue(), new MultiplyOperationExecutor())
            .put(OpType.DIVIDE.getValue(), new DivideOperationExecutor())
            .put(OpType.SQRT.getValue(), new SqrtOperationExecutor())
            .put(OpType.CLEAR.getValue(), new ClearOperatorExecutor())
            .put(OpType.UNDO.getValue(), new UndoOpratorExecutor())
            .build();

    public IOpratorExecuctor getExecutor(String ops) {
        return execuctorMap.get(ops);
    }

}
