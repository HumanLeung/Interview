package com.company.designpattern.strategy;

/**
 * @author Administrator
 */
public class CopperCard implements VipCard{
    @Override
    public void discount() {
        System.out.println("铜卡打9折");
    }

}
