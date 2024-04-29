package com.company.designpattern.factory.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        Car car = new LamborghiniFactory().getCar();
        Car car1 = new PorscheFactory().getCar();

        car.name();//兰博基尼
        car1.name();//保时捷
    }
}
