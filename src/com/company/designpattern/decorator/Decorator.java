package com.company.designpattern.decorator;

public abstract class Decorator extends Component{
    public Component component;

    protected Decorator(Component component){
        this.component = component;
    }

    public void execute(){
        component.execute();
    }
}
