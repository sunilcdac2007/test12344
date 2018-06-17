package com.harman.work;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncrypUtility {
	
	public static void main(String args[])
	{ 
		EncrypUtility encUtil = new EncrypUtility();
		encUtil.aesEncryptHttpsForPerks();
	  	
		try{
			//System.out.println(key.getBytes("UTF-8").length);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private byte[] mergeBytes(byte[] source, byte[] target)
	{
		byte[] mergedBytes = new byte[source.length + target.length];
		System.arraycopy(source, 0, mergedBytes, 0, source.length);
		System.arraycopy(target, 0, mergedBytes, source.length, target.length);
		return mergedBytes;
	}
	public void aesEncryptHttpsForPerks()
	{
		String apiKey = "123ABC";
		String clientID = "C874541C-2374-43DC-AE92-E243710262AE";
		String employeeID = "Employee1";
		boolean getSSOUrl = false;
		String firstName = "Employee";
		String lastName = "One";
		String emailAddress = "eone@perks.com";
		String phoneNumber = "";
		//String isoTS = getUTCNowTime();
		String isoTS = "2016-10-01T13:45:30.0000000Z";
		
		String concatParams = "ApiKey=" + apiKey + "&ClientID=" + clientID + "&EmployeeID=" + employeeID + "&GetSsoUrl=true&FirstName=" + firstName;
		concatParams = concatParams + "&LastName=" + lastName + "&EmailAddress=" + emailAddress;
		System.out.println(concatParams);
		byte[] secureIV = getSecureIV();
		String encryptedData = encryptData("TEST", secureIV);
		System.out.println("ENC:" + encryptedData);
		String decryptedData = decryptData(encryptedData, secureIV);
		System.out.println("DEC:" + decryptedData);
	}
	
	private String decryptData(String encDataValue, byte[] initVector)
	{
		//String initVector = "RandomInitVector"; // 16 bytes IV
		//byte[] initVector = getSecureIV();
		String key = "Jar12345Jar12345Jar12345Jar12345"; // 128 bit key  Jar12345Jar12345
		try {
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encDataValue));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
	
	private byte[] getSecureIV()
	{
		// change need to do
		byte[] iv = new byte[16];
		SecureRandom prng = new SecureRandom();
		prng.nextBytes(iv);
		return iv;
	}
	
	
	private String encryptData(String dataValue, byte[] initVector)
	{
		String key = "Jar12345Jar12345Jar12345Jar12345"; //"Jar12345Jar12345Jar12345Jar12345"   this key is original; // 128 bit key   Jar12345Jar12345
        //String initVector = "RandomInitVector"; // 16 bytes IV
		//byte[] initVector = getSecureIV();
		String aesKey = "";
		try
		{
			IvParameterSpec iv = new IvParameterSpec(initVector);
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
	
	        byte[] encrypted = cipher.doFinal(dataValue.getBytes());
	        byte[] padEncWithIV = mergeBytes(initVector, encrypted);
	        return Base64.encodeBase64String(padEncWithIV);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return null;
	    }

	}

}
