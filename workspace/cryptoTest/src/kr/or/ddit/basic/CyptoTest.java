package kr.or.ddit.basic;

import java.security.NoSuchAlgorithmException;

import kr.or.ddit.util.CryptoUtil;

public class CyptoTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//암호화할 데이터
		String plainText = "Hello, World";
				//"Hello, World! 가나다라 대한민국 12345 %^&*#()";

		System.out.println("MD5     : " + CryptoUtil.md5(plainText));
		System.out.println("SHA-256 : " + CryptoUtil.sha256(plainText));
		System.out.println("SHA-512 : " + CryptoUtil.sha512(plainText));
	}

}
