package com.rpgzonewebrest.service;

import java.util.Date;

import com.rpgzonewebrest.models.user.Normal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
	
	private static final Long EXPIRATION_TIME = new Long(1800000);
	private static final String KEY = "Fraseautenticacao123";
	
	public static String generateToken(Normal user) {
		return Jwts.builder()
							.setIssuedAt(new Date(System.currentTimeMillis() ) )
							.setSubject(user.getID().toString())
							.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME.longValue() ) )
							.signWith(SignatureAlgorithm.HS256, KEY)
							.compact();
	}
	
	public static Claims decodeToken(String tokenRestored) {
		return Jwts.parser()
					.setSigningKey(KEY)
					.parseClaimsJws(tokenRestored)
					.getBody();
	}
}
