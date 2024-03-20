package com.company.designpattern.decorator;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.execute();
    }
}
