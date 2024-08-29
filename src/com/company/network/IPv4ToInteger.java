package com.company.network;

import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * @author Administrator
 */
public class IPv4ToInteger {


    public static int ipv4ToInteger(String ipv4) throws Exception {
        InetAddress address = InetAddress.getByName(ipv4);
        byte[] bytes = address.getAddress();
        return ByteBuffer.allocate(4).put(bytes).getInt(0);
    }


    public static void main(String[] args) {
        try {
            String ipv4 = "100.101.1.5";
            int integer = ipv4ToInteger(ipv4);
            System.out.println("IPv4: " + ipv4 + " -> Integer: " + integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
