package com.company.designpattern.decorator;

/**
 * @author Administrator
 */
public class ConcreteComponent extends Component{
    @Override
    public void execute() {
        System.out.println("具体组织处理业务逻辑");
    }
}
