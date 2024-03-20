package com.company.designpattern.proxy.staticproxy;

public class TestStaticProxy {
    public static void main(String[] args) {
        IRentHouse iRentHouse = new RentHouse();
        //定义中介
        IRentHouse agentProxy = new AgentProxy(iRentHouse);
        //中介租房
        agentProxy.rentHouse();
    }
}
