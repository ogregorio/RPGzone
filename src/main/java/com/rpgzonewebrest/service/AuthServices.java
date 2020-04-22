package com.rpgzonewebrest.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;

import java.util.Iterator;
import java.util.List;

public class AuthServices {
	
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static String encrypt(String input) {
		return "test";
	}
	public static  Long requireDecryption(String token) {
		System.out.println("token require decryption " + token);
		if(token == null) {
			return null;
		}
		
		try {
			DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("Fraseautenticacao123"))//Colocar essa fraseautenticacao123 em outro lugar depois
								.build()
								.verify(token);
			System.out.println("DecodedJWT " + decodedJWT);
			Long userLoggedID = decodedJWT.getClaim("userID").asLong();
			System.out.println("userLoggedID DECRYPTED teste String " + decodedJWT.getClaim("userID").asString());
			System.out.println("userLoggedID DECRYPTED teste sem tipo " + decodedJWT.getClaim("userID"));
			System.out.println("userLoggedID DECRYPTED teste Integer " + decodedJWT.getClaim("userID").asInt());
			//chamada autenticada 
			return userLoggedID;
		} catch(JWTVerificationException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Long registeredOnDB(Normal user) {
		List<Normal> users = normalDAO.getAll();
		Normal userOnDB = null;
		for(Iterator<Normal> iterator = users.iterator(); iterator.hasNext();) {
			userOnDB = (Normal) iterator.next();
			if( user.getUserName().equals(userOnDB.getUserName())  && user.getPassword().equals(userOnDB.getPassword()) ) {
				return userOnDB.getID();
			}
		}
		return new Long(0);
	}
}
