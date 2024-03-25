package com.company.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class Subject implements Observable{

    private final List<Observer> list = new ArrayList<>();
    @Override
    public void add(Observer observer) {
        list.add(observer);
    }
    @Override
    public void del(Observer observer) {
        list.remove(observer);
    }
    @Override
    public void notify(String message) {
        list.forEach(observer -> observer.update(message));
    }

}
