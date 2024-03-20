package com.company.designpattern.singletons;

/**
 * @author Administrator
 */
public class LazySingleton {
    private static volatile LazySingleton singleton;
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    public static LazySingleton getSyncInstance(){
        if (singleton == null){
            synchronized (LazySingleton.class){
                if (singleton == null){
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
