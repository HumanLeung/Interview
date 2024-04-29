package com.company.designpattern.factory.factorymethod;

public class LamborghiniFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Lamborghini();
    }
}
