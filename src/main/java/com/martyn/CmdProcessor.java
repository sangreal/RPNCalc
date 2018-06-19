package com.martyn;

import com.martyn.ops.NumExecutor;
import com.martyn.ops.OperatorExecutorFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class CmdProcessor {

    private ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList;

    public CmdProcessor(ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) {
        this.queueList = queueList;
    }

    public void process(String ch) throws RpnException {
        if (StringUtils.isAllBlank(ch)) return;

        if (Utils.isNumber(ch)) {
            NumExecutor.execute(ch, queueList);
        } else if (Utils.isOperators(ch)) {
            operatorExecute(ch);
        }
    }

    public void operatorExecute(String op) throws RpnException {
        Optional.ofNullable(OperatorExecutorFactory
                .getInstance()
                .getExecutor(op))
                .orElseThrow(() -> new RpnException(ErrType.INVALID_OPERATOR, "This is a invalid operator"))
                .execute(op, queueList);
    }

}
