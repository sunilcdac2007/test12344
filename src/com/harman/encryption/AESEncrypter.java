package com.harman.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESEncrypter {

	private static byte[] getSecureIV()
	{

		byte[] iv = new byte[16];
		SecureRandom prng = new SecureRandom();
		prng.nextBytes(iv);
		return iv;		
	}
	 private static final byte[] SALT=getSecureIV();
	/*
    private static final byte[] SALT = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03,
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    }; */
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 256;
    private Cipher ecipher;
    private Cipher dcipher;
    byte[] iv;
    
    AESEncrypter(String passPhrase) throws Exception {
        SecretKey secret = getEncryptedSecretKey(passPhrase);

        ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ecipher.init(Cipher.ENCRYPT_MODE, secret);
        
        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
         iv = ecipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        dcipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    }

	/**
	 * @param passPhrase
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private SecretKey getEncryptedSecretKey(String passPhrase)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		System.out.println(" iv value encrypted side ");
    	System.out.println(convertByteToString(SALT));
        KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
    	//KeySpec spec = new PBEKeySpec(passPhrase.toCharArray());
    	SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		return secret;
	}

	private SecretKey getDecryptredSecretKey(String passPhrase,byte[] iv)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
	//	KeySpec spec = new PBEKeySpec(passPhrase.toCharArray());
		SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		return secret;
	}
    public String encrypt(String encrypt) throws Exception {
        byte[] bytes = encrypt.getBytes("UTF8");
        byte[] encrypted = encrypt(bytes);
        
        return new BASE64Encoder().encode(encrypted);
    }
    public String encrypt_1(String encrypt) throws Exception {
        byte[] bytes = encrypt.getBytes("UTF8");
        byte[] encrypted = encrypt(bytes);
        System.out.println(" iv value befor add in encrypted data");
    	System.out.println(convertByteToString(iv));
        byte[] padEncWithIV = mergeBytes(iv, encrypted);
        return new BASE64Encoder().encode(padEncWithIV);
    }
    private static byte[] mergeBytes(byte[] source, byte[] target)
    {
    	byte[] mergedBytes = new byte[source.length + target.length];
    	System.arraycopy(source, 0, mergedBytes, 0, source.length);
    	System.arraycopy(target, 0, mergedBytes, source.length, target.length);
    	return mergedBytes;
    }
    public byte[] encrypt(byte[] plain) throws Exception {
        return ecipher.doFinal(plain);
    }

    public String decrypt(String encrypt) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(encrypt);
        byte[] decrypted = decrypt(bytes);
        return new String(decrypted, "UTF8");
    }

    public String decrypt_1(String encrypt) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(encrypt);
        byte[] encryptedByte = copyEncryptedBytes(bytes);
        byte[] iv =copyIVBytes(bytes);
        byte[] decrypted = decrypt(encryptedByte,iv);
        return new String(decrypted, "UTF8");
    }
    public byte[] decrypt(byte[] encrypt,byte[] iv) throws Exception {
    	String password ="b4 a3 65 86 f3 81 22 2f 20 ed f4 7c 7a 6b f6 69 f5 4c ac e6 0c cf 8f 3e 72 c8 ee c9 e0 6f dd 39"; //"PASSWORD";
    	dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
       // iv = ecipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
       dcipher.init(Cipher.DECRYPT_MODE, getDecryptredSecretKey(password,SALT), new IvParameterSpec(iv));
    	return dcipher.doFinal(encrypt);
    }

    private static byte[] copyIVBytes(byte[] source)
    {
    	byte[] IV = new byte[16];
    	System.arraycopy(source, 0, IV, 0, 16);
    	System.out.println(" iv value");
    	System.out.println(convertByteToString(IV));
    	return IV;
    }
    private static byte[] copyEncryptedBytes(byte[] decodData) {
    	
    	
    	byte[] mergedBytes = new byte[decodData.length-16];
    	System.arraycopy(decodData, 16, mergedBytes, 0, mergedBytes.length);
    	return mergedBytes;
    }
    public static String convertByteToString(byte[] data)
    {
    	StringBuffer sb = new StringBuffer();
    	for (byte b : data) {
            sb.append(String.format("%02X ", b));
        }
    	return sb.toString();
    }
    public byte[] decrypt(byte[] encrypt) throws Exception {
        return dcipher.doFinal(encrypt);
    }

    public static void main(String[] args) throws Exception {

        String message = "ApiKey=123ABC&ClientID=C874541C-2374-43DC-AE92-E243710262AE&EmployeeID=2369485&GetSsoUrl=true&FirstName=Christina&LastName=Alexander&EmailAddress=clgalexander1978@gmail.com"; //"MESSAGE";
        String password ="b4 a3 65 86 f3 81 22 2f 20 ed f4 7c 7a 6b f6 69 f5 4c ac e6 0c cf 8f 3e 72 c8 ee c9 e0 6f dd 39"; //"PASSWORD";

        AESEncrypter encrypter = new AESEncrypter(password);
        String encrypted = encrypter.encrypt_1(message);
        String decrypted = encrypter.decrypt_1(encrypted);

        System.out.println("Encrypt(\"" + message + "\", \"" + password + "\") = \"" + encrypted + "\"");
        System.out.println("Decrypt(\"" + encrypted + "\", \"" + password + "\") = \"" + decrypted + "\"");
    }
}