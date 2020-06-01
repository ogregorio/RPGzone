package com.rpgzonewebrest.dto;

import java.util.ArrayList;
import java.util.List;

//import com.rpgzonewebrest.authExceptions.InvalidDateException;
//import com.rpgzonewebrest.models.data.BrazilianDate;
import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.rpgzonewebrest.config.RoomConfig;
//import com.rpgzonewebrest.util.Ordenador;
//import com.rpgzonewebrest.util.Ordenavel;

public class RoomDTO {
	private String roomID;
	private String roomNick;
	private String qtdeUsersInRoom;
	private RoomConfig roomConfig;
	private String roomDescription;
	private List<SessionDTO> sessions = new ArrayList<SessionDTO>();
	private List<Long> users = new ArrayList<Long>();
	//private List<Ordenavel> ordenado = new ArrayList<Ordenavel>();
	
	public RoomDTO(Room room) {
		this.setRoomID( room.getRoomID().toString() );
		this.setRoomNick(room.getRoomNick());
		this.setQtdeUsersInRoom( String.valueOf(room.getUsers().size()) );
		this.setRoomConfig( room.getRoomConfig() );
		this.setRoomDescription( room.getRoomDescription() );
		this.setSessions( room.getSessions() );
		this.setUsers( room.getUsers() );
		/*SessionDTO sessionDTO = null;
		SessionDTO sessionDTO1 = null;
		SessionDTO sessionDTO2 = null;
		try {
			sessionDTO = new SessionDTO(new BrazilianDate(2000, 5, 10), "rua1", "12345380", "Brazil" );
			sessionDTO1 = new SessionDTO(new BrazilianDate(2000, 4, 10), "rua3", "11145386", "Brazil");
			sessionDTO2 = new SessionDTO(new BrazilianDate(2000, 4, 9), "rua2", "12245580", "Brazil");
			
		} catch (InvalidDateException e) { e.printStackTrace(); }
		
		sessions.add(sessionDTO);
		sessions.add(sessionDTO1);
		sessions.add(sessionDTO2);*/
		/*List<Ordenavel> dates = new ArrayList<Ordenavel>();
		sessions.forEach( session -> {
			dates.add( session.getBrazilianDate() );
		} );*/
		//this.setOrdenado( Ordenador.crescente(dates) );
		
	}
	
	public String getRoomID() {
		return roomID;
	}
	public String getRoomNick() {
		return roomNick;
	}

	public String getQtdeUsersInRoom() {
		return qtdeUsersInRoom;
	}
	
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public void setRoomNick(String roomNick) {
		this.roomNick = roomNick;
	}

	public void setQtdeUsersInRoom(String qtde) {
		this.qtdeUsersInRoom = qtde;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public RoomConfig getRoomConfig() {
		return roomConfig;
	}

	public void setRoomConfig(RoomConfig roomConfig) {
		this.roomConfig = roomConfig;
	}

	public List<SessionDTO> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionDTO> sessions) {
		this.sessions = sessions;
	}

	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}

	/*public List<Ordenavel> getOrdenado() {
		return ordenado;
	}

	public void setOrdenado(List<Ordenavel> ordenado) {
		this.ordenado = ordenado;
	}*/
}
