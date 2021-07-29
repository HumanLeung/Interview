package com.company.designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo implements Observer<Person>{
    public static void main(String[] args) {
        new ObserverDemo();
    }
    public ObserverDemo() {
        Person person = new Person();
        person.subscribe(this);
        for (int i = 20; i < 24; ++i) {
            person.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangeEventArgs<Person> args) {
        System.out.println("Person's" +args.propertyName + " has changed to "
        + args.newValue);
    }
}
class PropertyChangeEventArgs<T>
{
    public T source;
    public String propertyName;
    public Object newValue;

    public PropertyChangeEventArgs(T source, String propertyName, Object newValue){
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

interface Observer<T>
{
    void handle(PropertyChangeEventArgs<T> args);
}

class Observable<T> {
 private final List<Observer<T>> observable = new ArrayList<>();
 public void subscribe(Observer<T> observer) {
     observable.add(observer);
 }
 protected void propertyChanged(T source, String propertyName, Object newValue){
     for (Observer<T> o : observable) {
         o.handle(new PropertyChangeEventArgs<>(
                 source, propertyName,newValue
         ));
     }
 }
}

class Person extends Observable<Person>{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age)return;
        this.age = age;
        propertyChanged(this,"age",age);
    }
}
