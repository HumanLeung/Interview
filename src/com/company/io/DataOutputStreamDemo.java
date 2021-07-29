package com.company.io;

import java.io.*;

public class DataOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        DataOutputStream dout = new DataOutputStream(new FileOutputStream("src/output.txt"));
        try {
            dout.writeDouble(1.1);
            dout.writeInt(44);
            dout.writeBoolean(true);
            dout.writeChar('C');
            dout.writeUTF("hello");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot Open the Output File");
            return;
        }

        DataInputStream din = new DataInputStream(new FileInputStream("src/output.txt"));
        try {
            double a = din.readDouble();
            int b = din.readInt();
            boolean c = din.readBoolean();
            char d=din.readChar();
            System.out.println("Values: " + a + " " + b + " " + c+" " + d);
        } catch (IOException e) {
            System.out.println("Cannot Open the Input File");
            return;
        }


    }
}
