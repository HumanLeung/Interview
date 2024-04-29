package com.company.reflect;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Administrator
 */
@Getter
@Setter
public class Person<T, E> {
    List<Integer> integerList;
    List<Double> doubleList;
    List<ReflectTest> mainList;
    private String code;
}
