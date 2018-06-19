package com.martyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by martyn on 18-6-17.
 */
public class Application {

    public static void main (String[] args) {
        RPNCalculator rpnCalculator = new RPNCalculator();
        System.out.println("please input the numbers or operators");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            List<String> cmdList = new ArrayList<String>(Arrays.asList(str.split(" ")));
            rpnCalculator.processCmd(cmdList);
        }
    }
}
