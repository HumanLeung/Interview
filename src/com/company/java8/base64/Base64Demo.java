package com.company.java8.base64;

import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
      String originalStr = "Human Leung";
      String encodedStr = encode(originalStr);
      String decodedStr = decode(encodedStr);
        System.out.println(encodedStr);
        System.out.println(decodedStr);
    }

    public static String encode(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded =  encoder.encode(str.getBytes());
        return new String(encoded);
    }

    public static String decode(String str){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(str);
        return new String(decoded);
    }
}
