package com.company.designpattern.singletons;

/**
 * @author Administrator
 */
public class EagerSingleton {
    private static final EagerSingleton SINGLETON = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return SINGLETON;
    }


}
