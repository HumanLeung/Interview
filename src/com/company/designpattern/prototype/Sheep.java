package com.company.designpattern.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 */
@Getter
@Setter

public class Sheep implements Cloneable {
    public Sheep(String name, Integer age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }
    private String name;
    private Integer age;
    private String color;
    private String address;
    public Sheep friend;


    @Override
    public Sheep clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
