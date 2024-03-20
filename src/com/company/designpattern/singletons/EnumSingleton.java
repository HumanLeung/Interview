package com.company.designpattern.singletons;

/**
 * @author Administrator
 */

public enum EnumSingleton {
    INSTANCE;
    EnumSingleton(){
        System.out.println("枚举创建对象了");
    }
}
