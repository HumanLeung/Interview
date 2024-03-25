package com.company.designpattern.observer;

/**
 * @author Administrator
 */
public interface Observable {

    void add(Observer observer);

    /**
     * @param observer
     */
    void del(Observer observer);

    /**
     * @param message
     */
    void notify(String message);
}
