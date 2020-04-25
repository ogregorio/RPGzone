package com.rpgzonewebrest.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UrlGravatarGenerator {
	public static String urlGravatar(String email) throws NoSuchAlgorithmException {
	       MessageDigest message = MessageDigest.getInstance("MD5");
	       message.update(email.getBytes(),0,email.length());
	       BigInteger tempMD5 = new BigInteger(1,message.digest());
	       String FinalEmail = "https://www.gravatar.com/avatar/"+tempMD5.toString(16)+".jpg";
	       return FinalEmail;
	}
}
