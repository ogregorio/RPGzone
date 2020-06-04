package com.rpgzonewebrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.rpgzonewebrest.config.RoomConfig;


public class RoomDTO {
	private String roomID;
	private String roomNick;
	private String qtdeUsersInRoom;
	private RoomConfig roomConfig;
	private String roomDescription;
	private List<SessionDTO> sessions = new ArrayList<SessionDTO>();
	private List<Long> users = new ArrayList<Long>();
	
	public RoomDTO(Room room) {
		this.setRoomID( room.getRoomID().toString() );
		this.setRoomNick(room.getRoomNick());
		this.setQtdeUsersInRoom( String.valueOf(room.getUsers().size()) );
		this.setRoomConfig( room.getRoomConfig() );
		this.setRoomDescription( room.getRoomDescription() );
		this.setSessions( room.getSessions() );
		this.setUsers( room.getUsers() );	
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
}
