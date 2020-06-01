package com.rpgzonewebrest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dto.InviteDTO;
import com.rpgzonewebrest.dto.NotificationDTO;
import com.rpgzonewebrest.dto.UserDTO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;



public class UserServices {
	
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static List<UserDTO> searchUsersFilter(Normal userLogged) {
		List<Normal> list = normalDAO.getAll();
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		list.forEach( user -> {
			if(!user.equals(userLogged)) {
				listDTO.add(new UserDTO(user));
			}
		});
		return listDTO;
	}
	
	
	public static ResponseEntity<List<InviteDTO>> deleteIviteRoom(Normal userLogged, Long roomID) {
		List<InviteDTO> invitesDTO = userLogged.getInvitesDTO();
		boolean finded = false;
		for(Iterator<InviteDTO> iterator = invitesDTO.iterator(); !finded && iterator.hasNext();) {
			InviteDTO invite = iterator.next();
			if( invite.getRoomID().equals(roomID) ) {
				invitesDTO.remove(invitesDTO.indexOf(invite));
				finded = true;
			}
		}
		userLogged.setInvitesDTO(invitesDTO);
		normalDAO.update(userLogged);
		return finded ? ResponseEntity.ok(normalDAO.get(userLogged.getID()).getInvitesDTO()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	public static ResponseEntity<List<InviteDTO>> deleteIviteSession(Normal userLogged, Long sessionID) {
		List<InviteDTO> invitesDTO = userLogged.getInvitesDTO();
		boolean finded = false;
		for(Iterator<InviteDTO> iterator = invitesDTO.iterator(); !finded && iterator.hasNext();) {
			InviteDTO invite = iterator.next();
			if( invite.getSession() != null && invite.getSession().getSessionID().equals(sessionID) ) {
				invitesDTO.remove(invitesDTO.indexOf(invite));
				finded = true;
			}
		}
		userLogged.setInvitesDTO(invitesDTO);
		normalDAO.update(userLogged);
		return 	finded ?
				ResponseEntity.ok(normalDAO.get(userLogged.getID()).getInvitesDTO()) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	public static ResponseEntity<List<NotificationDTO>> deleteNotification(Normal userLogged, Long notificationID){
		List<NotificationDTO> notificationsDTO = userLogged.getNotificationsDTO();
		boolean finded = false;
		for(Iterator<NotificationDTO> iterator = notificationsDTO.iterator(); !finded && iterator.hasNext();) {
			NotificationDTO notification = iterator.next();
			
			if(notification.getNotificationID().equals(notificationID)) {
				notificationsDTO.remove(notificationsDTO.indexOf(notification));
				finded = true;
			}
		}
		userLogged.setNotificationsDTO(notificationsDTO);
		normalDAO.update(userLogged);
		return 	finded ? 
				ResponseEntity.ok(normalDAO.get(userLogged.getID()).getNotificationsDTO()) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
