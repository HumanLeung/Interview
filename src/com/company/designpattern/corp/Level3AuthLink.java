package com.company.designpattern.corp;

import java.util.Date;

/**
 * @author Administrator
 */
public class Level3AuthLink extends AuthLink {
    public Level3AuthLink(String levelUserId, String
            levelUserName) {
        super(levelUserId, levelUserName);
    }
    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,
                orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", levelUserName);
        }
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批完成", " 时间：", f.format(date), " 审批人：",
                    levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
