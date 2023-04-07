package com.trueact.encryption;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DbPasswordCipher {

  public static void main(String[] args) {
    if (args.length > 1 && "decrypt".equals(args[0])) {
      DbPasswordCipher dbPasswordCipher = new DbPasswordCipher();
      System.out.println(dbPasswordCipher.decrypt(args[1]));
    }
    else {
      try {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey secretKey = new SecretKeySpec(AdunoDbPasswordProvider.KEY.getBytes(), "AES");

        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        Scanner s = new Scanner(System.in);

        System.out.print("DB password: ");
        String plainText = s.next();

        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + cipherText.length);
        byteBuffer.putInt(iv.length);
        byteBuffer.put(iv);
        byteBuffer.put(cipherText);
        byte[] cipherMessage = byteBuffer.array();

        String encodedPassword = Base64.getEncoder()
            .encodeToString(cipherMessage);

        System.out.println();
        System.out.println(encodedPassword);
        System.out.println();
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String decrypt(String encryptedPassword) {
    try {
      byte[] decodedPassword = Base64.getDecoder()
          .decode(encryptedPassword);

      SecretKey secretKey = new SecretKeySpec(AdunoDbPasswordProvider.KEY.getBytes(), "AES");

      ByteBuffer byteBuffer = ByteBuffer.wrap(decodedPassword);
      int ivLength = byteBuffer.getInt();
      if (ivLength < 12 || ivLength > 16) { // check input parameter
        throw new IllegalArgumentException("invalid iv length");
      }
      byte[] iv = new byte[ivLength];
      byteBuffer.get(iv);
      byte[] cipherText = new byte[byteBuffer.remaining()];
      byteBuffer.get(cipherText);

      final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
      cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

      String plainText = new String(cipher.doFinal(cipherText));

      return plainText;
    }
    catch (Exception ex) {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}
