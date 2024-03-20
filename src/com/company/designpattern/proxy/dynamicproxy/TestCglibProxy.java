package com.company.designpattern.proxy.dynamicproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author Administrator
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        //生成虚拟代理类的代码，本来虚拟代理子类是看不见的，
        //下面这句话的作用就是把执行过程中cglib增强后的class字节码文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\aop");
        CglibProxy proxy = new CglibProxy(new Student("张三"));
        Student student = (Student) proxy.getProxy();
        student.wakeup();
        student.sleep();

        proxy = new CglibProxy(new Doctor("王教授"));
        Doctor doctor = (Doctor) proxy.getProxy();
        doctor.wakeup();
        doctor.sleep();

        proxy = new CglibProxy(new Dog("旺旺"));
        Dog dog = (Dog) proxy.getProxy();
        dog.wakeup();
        dog.sleep();

        proxy = new CglibProxy(new Cat("咪咪"));
        Cat cat = (Cat) proxy.getProxy();
        cat.wakeup();
        cat.sleep();
    }
}
