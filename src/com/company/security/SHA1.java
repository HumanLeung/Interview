package com.company.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 */
public class SHA1 {
    public String encode(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            return parseByte2HexStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
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
        SHA1 sha1 = new SHA1();
        String content = "测试test";
        System.out.println(sha1.encode(content));
    }
}
