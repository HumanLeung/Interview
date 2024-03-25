package com.company.designpattern.corp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 */
public abstract class AuthLink {
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 审核人ID
     */
    protected String levelUserId;

    /**
     * 审核人姓名
     */
    protected String levelUserName;

    /**
     * 持有下一个处理类的引用
     */
    protected AuthLink next;
    protected AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }


    public AuthLink getNext() {
        return next;
    }
    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
