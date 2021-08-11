package com.company.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//filter --接受lambda
//limit --截断流
//skip跳过元素
//distinct--筛选,必须重写HashCode equals
//parallel 就是把一个数组分成多个数据块，并用不同的线程分别处理每个数据快的流
public class StreamAPI {
    List<Employee> employees = Arrays.asList(
            new Employee("haha", 18, 2000),
            new Employee("john", 14, 5000),
            new Employee("Anne", 21, 8000)
    );

    public static void main(String[] args) {
//        new StreamAPI().test();
//        new StreamAPI().test2();
//        new StreamAPI().test3();
//        new StreamAPI().test4();
//        new StreamAPI().test5();
//         new StreamAPI().test6();
//        new StreamAPI().test9();
//        new StreamAPI().test10();
        new StreamAPI().test12();
    }

    public void test() {
        List<Employee> ew = employees.stream()
                .filter((e) -> e.getAge() > 14).collect(Collectors.toList());
        System.out.println(ew);
        Stream<Employee> s = employees.stream().filter(e -> e.getAge() > 14);
        s.forEach(System.out::println);
//        System.out.println(s.filter(value -> value.getAge()> 18 ));
//        s.forEach(System.out::println);
    }

    public void test2() {
        employees.stream().filter(e -> {
            System.out.println("stop!");
            return e.getSalary() > 2;
        }).limit(2)
                .forEach(System.out::println);
    }

    public void test3() {
        List<String> list = Arrays.asList("ccc", "bbb", "aaa", "ddd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<String> name = employees.stream().map(Employee::getName).map(String::toUpperCase)
                .collect(Collectors.toList());
        name.forEach(System.out::println);
    }

    public void test4() {
        List<String> list = Arrays.asList("ccc", "bbb", "aaa", "ddd");
        list.stream().sorted().forEach(System.out::println);
    }

    public void test5() {
      Optional<Employee> employee = employees.stream().findFirst();
        employee.ifPresent(System.out::println);
    }

    public void test6() {
        Long count = (long) employees.size();
        System.out.println(count);

       Optional<Employee> emp = employees.stream().max(Comparator.comparingInt(Employee::getSalary));
        System.out.println(emp.get());
    }
    public void test7() {
       Optional<Integer>sum = employees.stream().map(Employee::getSalary).reduce(Integer::sum);
    }
    public void test8() {
       Set<String> set = employees.stream().map(Employee::getName)
               .collect(Collectors.toCollection(HashSet::new));

        Long count = employees.stream().filter(e -> e.getAge() > 1).count();
        System.out.println(count);
       Double avg = employees.stream().collect(Collectors.averagingInt(Employee::getAge));

       Double sum = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);
    }

    public void test9() {
        Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy((e) -> {
            if (e.getAge() < 18) {
                return "young";
            }else if (e.getAge() < 21) {
                return "medium";
            }else {
                return "old";
            }
        }));
    }

    public void test10() {
        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 2000));
        System.out.println(map);
    }

    public void test11() {
        IntSummaryStatistics dss = employees.stream().collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println(dss.getSum());
    }
    public void test12() {
        String str = employees.stream().map(Employee::getName).collect(Collectors.joining(",","===","==="));
        System.out.println(str);
    }
    public void test13() {
       Optional<Integer>count = employees.stream().map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }



}
