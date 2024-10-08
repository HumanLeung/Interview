package com.company.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author Administrator
 */
public class AESDemo {

    private static final String ALGORITHM = "AES/GCM/PKCS5Padding";

    public String encode(String str,String pwd) {
        byte[] result = null;
        try{

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(pwd.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = str.getBytes();
            result = cipher.doFinal(byteContent);
        }catch (Exception e){
            return null;
        }
        return parseByte2HexStr(result);
    }


    public String decode(String str,String pwd) {
        byte[] result = null;
        byte[] content = parseHexStr2Byte(str);
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(pwd.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            // 创建密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return new String(result);
    }

    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    private byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return new byte[0];
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        AESDemo aes = new AESDemo();
        String content = "测试加密";

        String pwd = "javayznbjavayznb";

        System.out.println("加密前：" + content);

        String encodeResultStr = aes.encode(content,pwd);
        System.out.println("加密后：" + encodeResultStr);

        String decodeResultStr = aes.decode(encodeResultStr,pwd);
        System.out.println("解密后：" + decodeResultStr);
    }
}
