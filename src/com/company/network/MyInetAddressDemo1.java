package com.company.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Administrator
 */
public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("PC-20221022BAXR");
        System.out.println(address);

        System.out.println(address.getHostAddress());

        System.out.println(address.getHostName());
    }
}
