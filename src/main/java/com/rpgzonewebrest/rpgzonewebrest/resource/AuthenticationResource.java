package com.rpgzonewebrest.rpgzonewebrest.resource;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpgzonewebrest.dto.TokenDTO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.service.AuthServices;
import com.rpgzonewebrest.service.TokenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/login")
public class AuthenticationResource {
	
	//private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	
	@PostMapping(produces="application/json")
	public ResponseEntity<TokenDTO> login(@RequestBody Normal user) {
		long id = AuthServices.registeredOnDB(user).longValue();
		if(id == 0) {//verifica se as credenciais do usuário são compatíveis com algum registro do banco de dados
			return ResponseEntity.notFound().build();
		}
		user.setID(new Long(id));
		AuthServices.updateLastLogin(user, new Date(System.currentTimeMillis() ) );
		String token = TokenService.generateToken(user);
		TokenDTO entity = new TokenDTO(token);
		
		return ResponseEntity.ok(entity);
	}
	
}
