package com.company.designpattern.factory.factorymethod;

/**
 * @author Administrator
 */
public class PorscheFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Porsche();
    }
}
