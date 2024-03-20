package com.company.designpattern.proxy.staticproxy;

/**
 * @author Administrator
 */
public class RentHouse implements IRentHouse{
    @Override
    public void rentHouse() {
        System.out.println("实现租房");
    }
}
