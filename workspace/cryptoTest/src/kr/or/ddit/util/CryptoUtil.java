package kr.or.ddit.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtil {
	/**
	 * 문자열을 MD5 방식으로 암호화(해시) 한다.
	 * @param str  암호화 할 문자열
	 * @return  암호화 된 문자열
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	
	
	//문자열을 SHA-256방식으로 암호화하는 메서드
	public static String sha256(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	
	
	//문자열을 SHA-512방식으로 암호화하는 메서드
	public static String sha512(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
		
	}
}
