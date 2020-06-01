package com.rpgzonewebrest.service;

import java.util.Iterator;
import java.util.List;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dto.InviteDTO;
import com.rpgzonewebrest.dto.InviteReqNewSessionDTO;
import com.rpgzonewebrest.dto.NotificationDTO;
import com.rpgzonewebrest.dto.SessionDTO;
import com.rpgzonewebrest.models.data.BrazilianDate;
import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.models.user.Admin;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;

public class SessionServices {
	
	private static DAO<Room, Long> roomDAO = DataBaseFake.getRoomData();
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static boolean createNewSession(Long idUserLogged, Long roomID, SessionDTO session) {
		Normal userLogged = normalDAO.get(idUserLogged);
		Room room = roomDAO.get(roomID);
		if(room == null || userLogged == null) return false;
		Admin adm = room.getAdmin(); 
		if( !( adm.getID().equals(userLogged.getID()) ) ) {//se n for admin enviar solicitação de nova sessão
			/*Solicitando permissão do admin para criar a sessão*/
			if( room.getUsers().indexOf(idUserLogged) == -1 ) return false;//vertificando se o usuário logado está na sala em questão
			
			notifyAdmin(adm, session, roomID);
			
			return true;
		}
		
		/*Criando sessão na sala*/
		createSessionOnRoom(room, session);
		
		/*Notificando todos os usuários quanto ao novo evento*/
		notifyAllUsers( "New session created on room " + room.getRoomNick(),
						room,
						session );
		return true;
		
	}
	
	public static SessionDTO updateSession(Long idUserLogged, Long roomID, Long sessionID, BrazilianDate brazilianDate) {
		Normal userLogged = normalDAO.get(idUserLogged);
		Room room = roomDAO.get(roomID);
		if(userLogged == null || room == null || !( room.getAdmin().getID().equals(idUserLogged) ) ) return null;
		boolean finded = false;
		SessionDTO session = null;
		List<SessionDTO> sessionsDTO = room.getSessions();
		for(Iterator<SessionDTO> iterator = sessionsDTO.iterator(); !finded && iterator.hasNext();) {
			session = iterator.next();
			if(session.getSessionID().equals(sessionID)) {
				finded = true;
			}
		}
		if(finded) {
			session.setBrazilianDate(brazilianDate);
			sessionsDTO.set( sessionsDTO.indexOf(session), session);
			room.setSessions(sessionsDTO);
			roomDAO.update(room);
			return session;
		}
		return null;
		 
		
	}
	public static void createSessionOnRoom(Room room, SessionDTO session) {
		
		List<SessionDTO> sessions = room.getSessions();
		sessions.add(session);
		room.setSessions(sessions);
		roomDAO.update(room);
	}
	public static void notifyAllUsers(String event, Room room, SessionDTO session) {
		room.getUsers().forEach( userID -> {
			Normal user = normalDAO.get(userID);
			List<NotificationDTO> notifications = user.getNotificationsDTO();
			notifications.add(new NotificationDTO(event, session));
			user.setNotificationsDTO(notifications);
			normalDAO.update(user);
		});
	}
	public static void notifyAdmin(Admin adm, SessionDTO session, Long roomID) {
		Normal admOnDB = normalDAO.get(adm.getID());
		List<InviteDTO> invites = admOnDB.getInvitesDTO();
		invites.add(new InviteReqNewSessionDTO(roomID, session));
		admOnDB.setInvitesDTO(invites);
		normalDAO.update(admOnDB);
	}
}
