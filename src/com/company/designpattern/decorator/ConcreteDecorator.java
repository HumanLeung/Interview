package com.company.designpattern.decorator;

/**
 * @author Administrator
 */
public class ConcreteDecorator extends Decorator{
    protected ConcreteDecorator(Component component) {
        super(component);
    }

    public void before(){
        System.out.println("ConcreteDecorator前置操作....");
    }

    public void after(){
        System.out.println("ConcreteDecorator后置操作....");
    }

    @Override
    public void execute() {
        before();
        component.execute();
        after();
    }
}
