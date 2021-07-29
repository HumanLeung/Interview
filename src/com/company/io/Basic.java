package com.company.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
//       int r = getInt();
//        System.out.println("result is: "+ r);
//        int result = getIntLBYL();
//        int result = getIntEAFP();
//        System.out.println(result);

    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try{
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

}
