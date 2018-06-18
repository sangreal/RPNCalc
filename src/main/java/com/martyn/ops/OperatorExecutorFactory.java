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

    private static Map<OpType, IOperatorExecuctor> execuctorMap = ImmutableMap.<OpType, IOperatorExecuctor>builder()
            .put(OpType.ADD, new AddOperatorExecutor())
            .put(OpType.MINUS, new MinusOperationExecutor())
            .put(OpType.MULTIPLY, new MultiplyOperationExecutor())
            .put(OpType.DIVIDE, new DivideOperationExecutor())
            .put(OpType.SQRT, new SqrtOperationExecutor())
            .put(OpType.CLEAR, new ClearOperatorExecutor())
            .put(OpType.UNDO, new UndoOperatorExecutor())
            .build();

    public IOperatorExecuctor getExecutor(String ops) {
        return execuctorMap.get(OpType.from(ops));
    }

}
