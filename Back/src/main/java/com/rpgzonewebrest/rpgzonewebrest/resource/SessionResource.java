package com.rpgzonewebrest.rpgzonewebrest.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpgzonewebrest.authExceptions.ExpiredTokenException;
import com.rpgzonewebrest.authExceptions.InvalidTokenException;
import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dto.SessionDTO;
import com.rpgzonewebrest.models.data.BrazilianDate;
import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.repository.DataBaseFake;
import com.rpgzonewebrest.service.AuthServices;
import com.rpgzonewebrest.service.SessionServices;

@RestController
@RequestMapping(value="/session", produces="application/json")
public class SessionResource {
	
	private static DAO<Room, Long> roomDAO = DataBaseFake.getRoomData();
	
	@PostMapping("/{roomID}")
	public ResponseEntity<SessionDTO> addNewSession(@RequestHeader String Authorization, @PathVariable Long roomID, @RequestBody SessionDTO session){
		Long idUserLogged;
		try {
			idUserLogged = AuthServices.requireDecryption(Authorization);
		}catch(ExpiredTokenException | InvalidTokenException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return 	SessionServices.createNewSession(idUserLogged, roomID, session) ? 
				ResponseEntity.ok(session) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	@PutMapping("/{roomID}/{sessionID}")
	public ResponseEntity<SessionDTO> updateSession(@RequestHeader String Authorization, @PathVariable Long roomID, @PathVariable Long sessionID, @RequestBody BrazilianDate brazilianDate){
		Long idUserLogged;
		try {
			idUserLogged = AuthServices.requireDecryption(Authorization);
		}catch(ExpiredTokenException | InvalidTokenException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		SessionDTO session = SessionServices.updateSession(idUserLogged, roomID, sessionID, brazilianDate);
		if(session != null) {
			SessionServices.notifyAllUsers("Session date changed, stay tuned for news", roomDAO.get(roomID), session);
			return ResponseEntity.ok(session);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
