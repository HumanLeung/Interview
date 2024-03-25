package com.company.designpattern.corp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class Client {
    private static final String RESULT_TAG = "测试结果：";
    public static void main(String[] args) throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = f.parse("2022-11-18 23:49:46");
        System.out.println(RESULT_TAG + authLink.doAuth("研发牛马", "1000998004813442", currentDate).toString());

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        System.out.println(RESULT_TAG + "模拟三级负责人审批，王工");
        System.out.println(RESULT_TAG + authLink.doAuth("研发牛马", "1000998004813441", currentDate).toString());

    }
}
