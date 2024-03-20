package com.company.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class TestJDKdynamicProxy {
    public static void main(String[] args) {
        JDKDynamicProxy proxy = new JDKDynamicProxy(new Dog("旺旺"));
        Animal dog = (Animal) Proxy.newProxyInstance(proxy.getClass()
                        .getClassLoader(), new Class[]{Animal.class}, proxy);

        dog.wakeup();
        dog.sleep();
    }
}
