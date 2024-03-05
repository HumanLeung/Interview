package com.company.java8.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/*
语法格式一: 无参数,并且无返回值
    () -> System.out.println("Hello Lambda!");

语法格式二: 有一个参数, 并且无返回值
    x -> System.out.println(x)

语法格式三: 若只有一个参数，小括号可以省略不写
   x -> System.out.println(x)

语法格式四: 有两个以上的参数,有返回值，并且Lambda体咋哄有多条语句
   System.out.println("函数式接口");
   return Integer.compare(x,y);
 语法格式五: 若Lambda 体中只有一条语句，return和大括号都可以省略不写
 Comparator<Integer> com = (x,y) -> Integer.compare(x,y);

 语法格式六: Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出,数据类型,即
 "类型推断" (Integer x, Integer y) -> Integer.compare(x,y);

 函数式接口:接口中只有一个抽象方法的接口,称为函数式接口
 @FunctionalInterface

 对象::实例方法名
 类::静态方法名
 类::实例方法名

 */

public class CompareDemo {
    String name = "String";
    public static void main(String[] args) {
         new CompareDemo().test6();
    }

    public void test1() {
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    public void test2(){
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer>ts = new TreeSet<>(com);
    }

    public void test6() {

       Integer num = operation(100,(x) -> {
                   System.out.println(this.name);
                   return x * x;
               }
       );
        System.out.println(num+this.name);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

}
