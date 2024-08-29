package com.company.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Administrator
 */
public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(dp);

        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("接收到数据"+ new String(data,0,len));
        System.out.println("该数据是从"+ address +"这台电脑中的" + port + "这端口发出的");

        datagramSocket.close();
    }
}
