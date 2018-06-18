package com.martyn.ops;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-17.
 */
public class NumExecutor {
    public static void execute(String ch, ConcurrentLinkedDeque<ConcurrentLinkedDeque<Double>> queueList) {
        ConcurrentLinkedDeque<Double> curQueue = new ConcurrentLinkedDeque<Double>(
                Optional.ofNullable(queueList.peekLast())
                        .orElseGet(ConcurrentLinkedDeque::new));
        curQueue.offer(Double.valueOf(ch));
        queueList.offerLast(curQueue);
    }
}
