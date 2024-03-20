package com.company.designpattern.strategy;

/**
 * @author Administrator
 */
public class Normal implements VipCard{
    @Override
    public void discount() {
        System.out.println("普通会员没有折扣");
    }
}
