package com.company.designpattern.corp;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Administrator
 */
public class Level2AuthLink extends AuthLink{
    private final Date beginDate = f.parse("2020-11-11 00:00:00");
    private final Date endDate = f.parse("2020-11-31 23:59:59");

    public Level2AuthLink(String levelUserId, String
            levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }
    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,
                orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", levelUserName);
        }
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成", " 时间：", f.format(date), " 审批人：",
                    levelUserName);
        }
        if (authDate.before(beginDate) ||
                authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成", " 时间：", f.format(date), " 审批人：",
                    levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
