package com.company.io;

import java.io.*;

public class ObjectOutPutStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
}
