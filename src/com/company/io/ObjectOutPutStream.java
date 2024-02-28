package com.company.io;

import java.io.*;

public class ObjectOutPutStream {
    public static void main(String[] args)  {
         writeFile();
    }

    public static void test() throws IOException, ClassNotFoundException{
        int data1 = 5;
        String data2 = "This is program";

        FileOutputStream file = new FileOutputStream("src/output.txt");
        ObjectOutputStream output = new ObjectOutputStream(file);

        output.writeInt(data1);
        output.writeObject(data2);
        output.writeUTF("Good to see you here");

        FileInputStream fileInputStream = new FileInputStream("src/output.txt");
        ObjectInputStream objStream = new ObjectInputStream(fileInputStream);

        System.out.println("Integer data :"+ objStream.readInt());

        System.out.println("String data :" + objStream.readObject().getClass());
//        System.out.println("String data :" + objStream.readUnsignedShort());
        output.close();
        objStream.close();
    }

    public static void writeFile(){

        String filePath = "src/outputStream.txt";
         //得到FileOutputStream对象
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            //输出缓冲流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)){

         //写入一个字符串
          String str = "hello, world";
          bufferedOutputStream.write(str.getBytes());
          System.out.println("写入成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
