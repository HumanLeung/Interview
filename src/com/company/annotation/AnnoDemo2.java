package com.company.annotation;
/*
 基本类型、字符串、枚举类型、注解类型
 2. 定义了属性，在使用时需要给属性赋值
 1.  如果定义了属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性赋值
      如果只有一个属性需要赋值，并且属性的名称时value，则value可以省略，直接定义值即可
      数组赋值时，值使用{}。如果数组中只有一个值，则{}省略

 元注解:用于描述注解的注解
       Target 目标
       Retention 时间
       Documented Api
       Inherited:继承

 在程序使用(解析)注解:获取注解中定义的属性值
 1。获取注解定义的位置的对象(Class, Method, Field)
 @. 获取指定的注解
 getAnnotation(class)
 */
public @interface AnnoDemo2 {
    int show1();
    String show2();
    Person person();
    String[] str();
}
