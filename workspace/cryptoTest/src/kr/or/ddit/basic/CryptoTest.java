package kr.or.ddit.basic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {
   private static final String key = "a1b2c3d4e5f6g7h8";
   public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, 
   NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
      // 암호화 할 데이터
      String plainText = 
    		//"Hello, World! 
            "Hello, World! 가나다라 대한민국 1234 ^%*()";
      
      
      System.out.println("MD5 : " + CryptoUtil.md5(plainText));
      System.out.println("SHA-256 : " + CryptoUtil.sha256(plainText));
      System.out.println("SHA-512 : " + CryptoUtil.sha512(plainText));
      
      System.out.println("-----------------------------------------");
      System.out.println();
      
      String result = CryptoUtil.encryptAES256(plainText, key);   //원본데이터를 암호화시켜서 출력
      String result2 = CryptoUtil.decryptAES256(result, key);
      
      System.out.println("원본데이터: " + plainText);
      System.out.println("암호화 된 데이터 : " + result);
      System.out.println("복호화 된 데이터 : " + result2);
      
      
   }
}