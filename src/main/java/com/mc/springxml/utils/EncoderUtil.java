package com.mc.springxml.utils;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;


public class EncoderUtil {

	
	private static final String SECRET_KEY_256_B64_STR = "1os1lftlA73WF92uyeDVo/+Cu64wuOGOtxpQSQ3BYZE=";
	private static final String IV_B64_STR = "CYWk0iMm3iN0v9WorOGzJw=="; 
	/**
	 * 문자열을 SHA-256 방식으로 암호화
	 * @param txt 암호화 하려하는 문자열
	 * @return String
	 * @throws Exception
	 */
	public static String getEncSHA256(String txt) throws Exception{
	    StringBuffer sbuf = new StringBuffer();
	     
	    MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
	    mDigest.update(txt.getBytes());
	     
	    byte[] msgStr = mDigest.digest() ;
	     
	    for(int i=0; i < msgStr.length; i++){
	        byte tmpStrByte = msgStr[i];
	        String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
	         
	        sbuf.append(tmpEncTxt) ;
	    }
	     
	    return sbuf.toString();
	}
	
	
	// 암호화
    public static String aesEncode(String str) throws Exception{
	   String key = SECRET_KEY_256_B64_STR;
	   byte[] ivPKey = Base64.decodeBase64(IV_B64_STR.getBytes("UTF-8"));
	   byte[] secretKey = Base64.decodeBase64(key.getBytes("UTF-8"));
	   System.out.println("secretKey : " + secretKey.length);
       SecretKeySpec keySpec = new SecretKeySpec(secretKey, "AES");
       
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivPKey));
 
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
 
        return enStr;
    }
 
    //복호화
    public static String aesDecode(String str) throws Exception{
    	String key = SECRET_KEY_256_B64_STR;
    	byte[] ivPKey = Base64.decodeBase64(IV_B64_STR.getBytes("UTF-8"));
    	byte[] secretKey = Base64.decodeBase64(key.getBytes("UTF-8"));
        SecretKeySpec keySpec = new SecretKeySpec(secretKey, "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivPKey));
		 
		byte[] byteStr = Base64.decodeBase64(str.getBytes());
		 
		return new String(c.doFinal(byteStr),"UTF-8");
    }
}


