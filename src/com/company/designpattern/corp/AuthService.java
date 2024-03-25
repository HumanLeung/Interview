package com.company.designpattern.corp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class AuthService {
    /**
     * 审批信息 审批人Id+申请单Id
     */
    private static final Map<String, Date> authMap = new HashMap<>();
    /**
     * 审核流程
     *
     * @param uId     审核人id
     * @param orderId 审核单id
     */
    public static void auth(String uId, String orderId) {
        System.out.println("进入审批流程,审批人ID: " + uId);
        authMap.put(uId.concat(orderId), new Date());
    }

    /**
     * 查询审核结果
     * @param uId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String uId, String orderId) {
        //key=审核人id+审核单子id
        return authMap.get(uId.concat(orderId));
    }
}
