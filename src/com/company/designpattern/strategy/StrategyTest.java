package com.company.designpattern.strategy;

/**
 * @author Administrator
 */
public class StrategyTest {
    public static void main(String[] args) {
        //金卡打7折
        VipCardFactory.getVIPCard("gold").discount();
        //银卡打8折
        VipCardFactory.getVIPCard("silver").discount();
        //普通会员没有折扣
        VipCardFactory.getVIPCard("other").discount();
    }
}
