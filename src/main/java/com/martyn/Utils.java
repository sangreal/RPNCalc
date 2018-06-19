package com.martyn;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by martyn on 18-6-17.
 */
public class Utils {
    public static boolean isNumber(String str) {
        return StringUtils.isNumeric(str);
    }

    public static boolean isOperators(String op) {
        Set<String> ops = new HashSet<String>(Arrays.asList("+", "-", "*", "/", "sqrt", "undo", "clear"));
        return ops.contains(StringUtils.lowerCase(op));
    }
}
