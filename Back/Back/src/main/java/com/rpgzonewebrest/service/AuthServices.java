package com.rpgzonewebrest.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rpgzonewebrest.authExceptions.ExpiredTokenException;
import com.rpgzonewebrest.authExceptions.InvalidTokenException;
import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;

import io.jsonwebtoken.Claims;

public class AuthServices {
	
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static  Long requireDecryption(String token)  throws ExpiredTokenException, InvalidTokenException{
		System.out.println("token require decryption " + token);
		if(token == null) {
			return null;
		}
		try {
			String tokenRestored = token.replace("Bearer ", "");
			Claims claims = TokenService.decodeToken(tokenRestored);
			System.out.println(claims.getIssuer());
			System.out.println(claims.getIssuedAt());
			
			//verifica se o token expirou
			if(claims.getExpiration().before( new Date(System.currentTimeMillis() ) )  ) {
				throw new ExpiredTokenException(claims.getExpiration());
			}
			else {
				Long userID =  Long.parseLong(claims.getSubject());
				//chamada autenticada 
				return userID;
			}
		} catch(ExpiredTokenException exp) {
			throw exp;
		} catch(Exception e) {
			throw new InvalidTokenException();
		}
		
	}
	
	public static Long registeredOnDB(Normal user) {
		List<Normal> users = normalDAO.getAll();
		Normal userOnDB = null;
		for(Iterator<Normal> iterator = users.iterator(); iterator.hasNext();) {
			userOnDB = (Normal) iterator.next();
			if( user.getNickName().equals(userOnDB.getNickName())  && user.getPassword().equals(userOnDB.getPassword()) ) {
				return userOnDB.getID();
			}
		}
		return new Long(0);
	}
	
	public static void updateLastLogin(Normal user, Date now) {
		Normal userAllData = normalDAO.get(user.getID()) ;
		userAllData.setLastLogin(now);
		normalDAO.update(userAllData);
	}
}
