package com.martyn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by martyn on 18-6-17.
 */
public class Utils {
    public static boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isOperators(String op) {
        Set<String> ops = new HashSet<String>(Arrays.asList("+", "-", "*", "/", "sqrt", "undo", "clear"));
        return ops.contains(op);
    }
}
