package com.company.designpattern.observer;

/**
 * @author Administrator
 */
public class ObserverTest {
    public static void main(String[] args) {
        Observable o = new Subject();
        WechatUser user1 = new WechatUser("张三");
        WechatUser user2 = new WechatUser("李四");
        WechatUser user3 = new WechatUser("王五");
        o.add(user1);
        o.add(user2);
        o.add(user3);
        o.notify("come on!");
    }
}
