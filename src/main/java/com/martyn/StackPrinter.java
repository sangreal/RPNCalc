package com.martyn;

import java.text.DecimalFormat;
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
            if (n % 1 == 0) {
                sb.append((int)n);
            } else {
                sb.append(String.format("%.10f", n));
            }

            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
