package com.rpgzonewebrest.rpgzonewebrest.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserResource {
	
	private DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	@PostMapping
	public ResponseEntity<Void> add(@RequestBody Normal user) {
		//Rota de registro de usuário fazer validação de usuários iguais na base
		normalDAO.add(user);
		return ResponseEntity.noContent().build();
	}//Deu Certo
	
	@GetMapping(produces="application/json")
	public @ResponseBody ResponseEntity<List<Normal>> getAll(@RequestAttribute("userID") Long idUserLogged){//Retorna todos os usuários
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		if(userLogged == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		List<Normal> list = normalDAO.getAll();
		return ResponseEntity.ok(list);
	}//Deu certo
	
	@GetMapping("/{id}")
	public ResponseEntity<Normal>  get(@PathVariable Long id, @RequestAttribute("userID") Long idUserLogged) {
		Normal user = normalDAO.get(id);
		if(user == null) {//usuário não encontrado
			return ResponseEntity.notFound().build();
		}
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		if(userLogged == null) {
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id, @RequestAttribute("userID") Long idUserLogged) {
		
		Normal user = normalDAO.get(id);
		if(user == null) {//Se o usuário passar um id inexistente na base de dados já bloqueia antes mesmo de verificar se ele está logado ou não
			return ResponseEntity.notFound().build();
		}
		
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		if(userLogged == null) {//Opção inacessível se o usuário não estiver logado
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		if(!userLogged.getID().equals(id)) {//Não pode dar deletar a conta de outro usuário
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		normalDAO.delete(user);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Normal> update(@PathVariable Long id, @RequestBody Normal newUser, @RequestAttribute("userID") Long idUserLogged){
		Normal user = normalDAO.get(id);
		if(user == null) {//Se o usuário passar um id inexistente na base de dados já bloqueia antes mesmo de verificar se ele está logado ou não
			return ResponseEntity.notFound().build();
		}
		
		Normal userLogged = normalDAO.get(idUserLogged);//recuperando os dados do usuário logado caso não esteja logado retorna null
		if(userLogged == null) {//Opção inacessível se o usuário não estiver logado
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if(!userLogged.getID().equals(id)) {//Não pode dar update nas informações de um outro usuário
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		BeanUtils.copyProperties(newUser, user);
		user.setID(id);
		
		normalDAO.update(user);
		return ResponseEntity.ok(user);
	}
	
}

