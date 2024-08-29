package com.company.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 */
public class MD5Demo {

    public String encode(String str){
        byte[] result = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes(StandardCharsets.UTF_8));
            result = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }


    private String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MD5Demo md5Demo = new MD5Demo();
        String content = "测试test";
        System.out.println(md5Demo.encode(content));
    }

}
