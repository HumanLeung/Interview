package com.company.java8.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo2 {
    public static void main(String[] args) {
        // Function takes 1 argument and process 1 result
        int increment = increment(0);
        System.out.println(increment);
        System.out.println("apply");

        System.out.println(incrementByOneFunction.apply(1));

        int multiply = multipleBy10.apply(1);
        System.out.println(multiply);

        System.out.println("combine");
        Function<Integer,Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multipleBy10);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

   static Function<Integer, Integer> incrementByOneFunction = number -> number++;

   static Function<Integer,Integer> multipleBy10 = number -> number * 10;

   static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;

   static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
       return (number + 1) * numToMultiplyBy;
   }

    static int increment(int number){
        return number + 1;
    }
}
