package com.company.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author Administrator
 */
public class AesGcmEncryptionDemo {

    // in bits
    private static final int AES_KEY_SIZE = 128;
    // in bytes
    private static final int GCM_IV_LENGTH = 12;
    // in bytes
    private static final int GCM_TAG_LENGTH = 16;

    // Method to generate a secret key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    // Method to generate a random IV
    public static byte[] generateIv() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        return iv;
    }

    // Method to encrypt a plaintext string
    public static String encrypt(String plaintext, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        byte[] encryptedIvAndText = new byte[GCM_IV_LENGTH + encryptedBytes.length];
        System.arraycopy(iv, 0, encryptedIvAndText, 0, GCM_IV_LENGTH);
        System.arraycopy(encryptedBytes, 0, encryptedIvAndText, GCM_IV_LENGTH, encryptedBytes.length);
        return Base64.getEncoder().encodeToString(encryptedIvAndText);
    }

    // Method to decrypt an encrypted string
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        byte[] encryptedIvAndText = Base64.getDecoder().decode(encryptedText);
        byte[] iv = new byte[GCM_IV_LENGTH];
        System.arraycopy(encryptedIvAndText, 0, iv, 0, iv.length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        byte[] originalText = cipher.doFinal(encryptedIvAndText, GCM_IV_LENGTH, encryptedIvAndText.length - GCM_IV_LENGTH);
        return new String(originalText);
    }

    public static void main(String[] args) {
        try {
            // Generate AES Key
            SecretKey secretKey = generateKey();

            // Generate IV
            byte[] iv = generateIv();

            // Original message
            String originalMessage = "Hello, World!";

            // Encrypt the message
            String encryptedMessage = encrypt(originalMessage, secretKey, iv);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            String decryptedMessage = decrypt(encryptedMessage, secretKey);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
