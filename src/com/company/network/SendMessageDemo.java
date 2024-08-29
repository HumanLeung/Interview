package com.company.network;

import java.io.IOException;
import java.net.*;

/**
 * @author Administrator
 */
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //
        DatagramSocket ds = new DatagramSocket();
        String str = "Hello！！！";
        byte[] bytes = str.getBytes();

        InetAddress address = InetAddress.getByName("127.0.0.1");

        int port = 10086;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(datagramPacket);
        ds.close();
    }
}
