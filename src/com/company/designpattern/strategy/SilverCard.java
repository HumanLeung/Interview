package com.company.designpattern.strategy;

/**
 * @author Administrator
 */
public class SilverCard implements VipCard{

    @Override
    public void discount() {
        System.out.println("银卡打8折");
    }

}
