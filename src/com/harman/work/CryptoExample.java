package com.harman.work;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class CryptoExample {

	
	public static void mian(String args[])
	{
		final String password = "I AM SHERLOCKED";  
        final String salt = KeyGenerators.string().generateKey();

        TextEncryptor encryptor = Encryptors.text(password, salt);      
        System.out.println("Salt: \"" + salt + "\"");

        String textToEncrypt = "*royal secrets*";
        System.out.println("Original text: \"" + textToEncrypt + "\"");

        String encryptedText = encryptor.encrypt(textToEncrypt);
        System.out.println("Encrypted text: \"" + encryptedText + "\"");

        // Could reuse encryptor but wanted to show reconstructing TextEncryptor
        TextEncryptor decryptor = Encryptors.text(password, salt);
        String decryptedText = decryptor.decrypt(encryptedText);
        System.out.println("Decrypted text: \"" + decryptedText + "\"");

        if(textToEncrypt.equals(decryptedText)) {
            System.out.println("Success: decrypted text matches");
        } else {
            System.out.println("Failed: decrypted text does not match");
        }       
	}
}
