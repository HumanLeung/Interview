package com.company.huawei.prarameter;

/**
 * @author Administrator
 */
public class Main {
    static int x = 10;

    static { x += 5; }

    static {x /= 3; }
    public static void main(String[] args) {


        float f = 11.1F;
        float e = 112.12F;
        double d = 11.1;

        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
        b3= (byte) (b1+b2);  /*语句1*/
        b6=b4+b5;    /*语句2*/
        b8= (byte) (b1+b4);  /*语句3*/
        b7= (byte) (b2+b5);
        System.out.println(b7);

        int a = 10;
        int b = -10;

        System.out.println(a << 2);

        System.out.println(5 >> 2);
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(1));
        int x =1;
        float y =2;
        System.out.println(x / y);

        System.out.println(~10);
    }
}
