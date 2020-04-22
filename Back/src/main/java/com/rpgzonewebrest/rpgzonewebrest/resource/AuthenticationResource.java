package com.rpgzonewebrest.rpgzonewebrest.resource;

import java.util.Date;

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
import com.rpgzonewebrest.service.TokenService;
import com.rpgzonewebrest.util.Token;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/login")
public class AuthenticationResource {
	
	//private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	
	@PostMapping(produces="application/json")
	public ResponseEntity<Token> login(@RequestBody Normal user) {
		long id = AuthServices.registeredOnDB(user).longValue();
		if(id == 0) {//verifica se as credenciais do usuário são compatíveis com algum registro do banco de dados
			return ResponseEntity.notFound().build();
		}
		user.setID(new Long(id));
		String token = TokenService.generateToken(user);
		/*String token = JWT.create()
													.withClaim("userID", user.getID())
													.withExpiresAt(new Date( System.currentTimeMillis() + EXPIRATION_TIME.longValue() ) )
													.sign(Algorithm.HMAC256("Fraseautenticacao123"));*/
		/*Cookie cookie = new Cookie("token", token);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(EXPIRATION_TIME.intValue()/1000);//Aqui é em segundos então por isso a divisão por 1000 já que o do token é em millis
		cookie.setPath("/");*/
		
		//response.addCookie(cookie);
		Token entity = new Token(token);
		
		return ResponseEntity.ok(entity);
	}
	
}
