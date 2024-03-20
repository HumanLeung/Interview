package com.company.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object bean;
    public JDKDynamicProxy(Object bean) {
        this.bean=bean;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("wakeup".equals(methodName)){
            System.out.println("早安~~~");
        }else if("sleep".equals(methodName)){
            System.out.println("晚安~~~");
        }
        return method.invoke(bean,args);
    }
}
