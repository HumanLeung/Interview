package com.company.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "com.company.annotation.Invoke", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method mehtod = cls.getMethod(methodName);
        mehtod.invoke(obj);
    }
}
