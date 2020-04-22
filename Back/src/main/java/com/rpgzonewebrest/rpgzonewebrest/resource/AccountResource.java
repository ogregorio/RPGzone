package com.rpgzonewebrest.rpgzonewebrest.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;
import com.rpgzonewebrest.service.AuthServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountResource {
	
	private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	@GetMapping(produces="application/json")
	public  ResponseEntity<Normal> getUserLogged(@RequestParam(required = false) String token){
		System.out.println(token);
		Long idUserLogged = AuthServices.requireDecryption(token);
		System.out.println(idUserLogged);
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		if(userLogged == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(userLogged);
	}
}
