package com.company.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

/**
 * @author Administrator
 */
public class FunctionTest {
    public static void main(String[] args) {
        String value = toLowerString(String::toLowerCase,"ABC");
        System.out.println(value);

        makeMoney(100, t -> System.out.println("made a lot money " + t ));

        List<Integer> list = addNumInList(10, () -> (new Random().nextInt() * 100));
        list.forEach(System.out::println);

        System.out.println(handleStr("abc", String::toLowerCase));

        IntUnaryOperator func = x -> x * 2;
        Integer result = func.applyAsInt(2);
        System.out.println(result);

        System.out.println(convert("1111", (s) -> {
            System.out.println(111);
            return Integer.parseInt(s);
        }, (i) -> {
            System.out.println(2222);
            return i + 5 + "";
        }));

        IntBinaryOperator add = Integer::sum;
        int sum = add.applyAsInt(5,1);
        System.out.println(sum);

        BinaryOperator<String> longerString = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;
        String strResult = longerString.apply("Hello", "Worlds");
        System.out.println(strResult);
    }



    public static String toLowerString(MyFunctionInterface<String> mf,String origin){
        return mf.getValue(origin);
    }

    public static void makeMoney(Integer money, IntConsumer consumer){
        consumer.accept(money);
    }
    public static List<Integer> addNumInList(int size, IntSupplier supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(supplier.getAsInt());
        }
        return list;
    }

    public static String handleStr(String s, UnaryOperator<String> f){
        return f.apply(s);
    }

    public static String convert(String s, Function<String,Integer> fun, Function<Integer,String> fun2){
       return fun.andThen(fun2).apply(s);
    }
}
