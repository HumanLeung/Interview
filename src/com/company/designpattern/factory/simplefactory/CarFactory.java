package com.company.designpattern.factory.simplefactory;

/**
 * @author Administrator
 */
public class CarFactory {
    public static Car getCar(String car){
        if ("保时捷".equals(car)){
            return new Porsche();
        }else if("兰博基尼".equals(car)){
            return new Lamborghini();
        }
            return null;
    }

    public static Object getCarByType(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName(className);
        return cls.newInstance();
    }
}
