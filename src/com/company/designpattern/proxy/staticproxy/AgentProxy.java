package com.company.designpattern.proxy.staticproxy;

/**
 * @author Administrator
 */
public class AgentProxy implements IRentHouse{
    private final IRentHouse iRentHouse;
    public AgentProxy(IRentHouse iRentHouse){
        this.iRentHouse = iRentHouse;
    }
    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        iRentHouse.rentHouse();
        System.out.println("中介负责维修管理");
    }
}
