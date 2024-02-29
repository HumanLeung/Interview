package com.company.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Administrator
 */
public class ChannelTest {
    public static void main(String[] args) {
//        write();
//        read();
        copy();
    }
    public static void write(){
        try(FileOutputStream fos = new FileOutputStream("src/nio.txt");){
            FileChannel channel = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello, World!".getBytes());
            //flip
            byteBuffer.flip();
            channel.write(byteBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void read(){
        try(FileInputStream is = new FileInputStream("src/nio.txt");){
            FileChannel channel = is.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            String rs = new String(buffer.array(),0,buffer.remaining());
            System.out.println(rs);
        }catch (IOException e){
           e.printStackTrace();
        }
    }

    public static void copy(){
        File srcFile = new File("src/nio.txt");
        File destFile = new File("src/duplicated_nio.txt");
        try(FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);){

            FileChannel fisChannel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(true){
                buffer.clear();
                int flag = fisChannel.read(buffer);
                if (flag == -1){
                    break;
                }
                buffer.flip();
                fosChannel.write(buffer);
            }
        }catch (IOException e){
              e.printStackTrace();
        }

    }
}
