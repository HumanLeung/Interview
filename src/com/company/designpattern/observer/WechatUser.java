package com.company.designpattern.observer;

import lombok.AllArgsConstructor;

/**
 * @author Administrator
 */
@AllArgsConstructor
public class WechatUser implements Observer{
    private String name;
    @Override
    public void update(String message) {
        System.out.println(name + "接收到了消息(观察到了):" + message);
    }
}
