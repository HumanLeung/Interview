package com.company.designpattern.strategy;

/**
 * @author Administrator
 */
public class GoldCard implements VipCard{
    @Override
    public void discount() {
        System.out.println("金卡打7折");
    }
}
