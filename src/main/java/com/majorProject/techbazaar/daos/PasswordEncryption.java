package com.majorProject.techbazaar.daos;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordEncryption {

public String passwordEncryption(String password){
		String salt="admin123!@#";
		String inputValue=password+salt;
		String encryptedValue=null;
		try{
			MessageDigest digest=MessageDigest.getInstance("MD5");
			digest.update(inputValue.getBytes(), 0, inputValue.length());
			encryptedValue=new BigInteger(1, digest.digest()).toString(16);
		}catch(Exception e){
			System.out.println("String not converted");
		}
		return encryptedValue;
	}

}
