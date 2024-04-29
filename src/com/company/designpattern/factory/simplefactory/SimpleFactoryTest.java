package com.company.designpattern.factory.simplefactory;

/**
 * @author Administrator
 */
public class SimpleFactoryTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Car car = CarFactory.getCar("兰博基尼");
        Car car1 = CarFactory.getCar("保时捷");
        car.name();
        car1.name();

        Car car2 = (Car) CarFactory.getCarByType("com.company.designpattern.factory.simplefactory.Porsche");
        car2.name();
    }
}
