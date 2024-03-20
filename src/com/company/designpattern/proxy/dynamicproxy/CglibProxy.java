package com.company.designpattern.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class CglibProxy implements MethodInterceptor {

    private final Enhancer enhancer = new Enhancer();
    private final Object bean;

    public CglibProxy(Object bean){
        this.bean = bean;
    }

    public Object getProxy(){
        //设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if ("wakeup".equals(methodName)){
            System.out.println("早安~~~");
        }else if("sleep".equals(methodName)){
            System.out.println("晚安~~~");
        }
        return method.invoke(bean,objects);
    }
}
