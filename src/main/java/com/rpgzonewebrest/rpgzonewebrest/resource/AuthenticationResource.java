package com.rpgzonewebrest.rpgzonewebrest.resource;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.service.AuthServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/login")
public class AuthenticationResource {
	
	//private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	private static final Long EXPIRATION_TIME = new Long(1800000);
	
	@PostMapping
	public ResponseEntity<Void> login(@RequestBody Normal user, HttpServletResponse response) {
		if(!AuthServices.registeredOnDB(user)) {//verifica se as credenciais do usuário são compatíveis com algum registro do banco de dados
			return ResponseEntity.notFound().build();
		}
		String token = JWT.create()
													.withClaim("userID", user.getID())
													.withExpiresAt(new Date( System.currentTimeMillis() + EXPIRATION_TIME ) )
													.sign(Algorithm.HMAC256("Fraseautenticacao123"));
		Cookie cookie = new Cookie("token", token);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(EXPIRATION_TIME.intValue()/1000);//Aqui é em segundos então por isso a divisão por 1000 já que o do token é em millis
		
		response.addCookie(cookie);
		
		return ResponseEntity.noContent().build();
	}
	
}
