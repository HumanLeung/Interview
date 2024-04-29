package com.company.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class AnnotationTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = MyClass.class;
        MyAnnotation myAnnotation = clazz.getAnnotation(MyAnnotation.class);
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(myAnnotation);
        Field value = invocationHandler.getClass().getDeclaredField("memberValues");
        value.setAccessible(true);
        Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
        System.out.println(memberValues);
        memberValues.put("value",12);
        System.out.println(myAnnotation.value());
    }
}
