package com.martyn;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by martyn on 18-6-18.
 */
public class StackPrinter {
    public static void print(ConcurrentLinkedDeque<Double> queue) {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: ");
        for (double n : queue) {
            sb.append(n);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
