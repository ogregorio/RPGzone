package com.rpgzonewebrest.rpgzonewebrest.resource;

/*import java.util.Iterator;
import java.util.List;*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpgzonewebrest.authExceptions.ExpiredTokenException;
import com.rpgzonewebrest.authExceptions.InvalidTokenException;
import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dto.UserDTO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;
import com.rpgzonewebrest.service.AuthServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountResource {
	
	private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	@GetMapping(produces="application/json")
	public  ResponseEntity<UserDTO> getUserLogged(@RequestHeader String Authorization){
		Long idUserLogged;
		try {
			idUserLogged = AuthServices.requireDecryption(Authorization);
		} catch(ExpiredTokenException | InvalidTokenException e) {
			e.printStackTrace();//debug
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		
		if(userLogged != null) {
			UserDTO userDTO = new UserDTO(userLogged);
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@GetMapping("/authenticated")//futuramente tentar usar este método para validar todos os outros para evitar repetição
	public ResponseEntity<Void> isAuthenticated(@RequestHeader String Authorization){
		Long idUserLogged;
		try {
			idUserLogged = AuthServices.requireDecryption(Authorization);
		} catch(ExpiredTokenException | InvalidTokenException e) {
			e.printStackTrace();//debug
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		Normal userLogged = normalDAO.get(idUserLogged);
		return (userLogged != null) ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
}
