package com.rpgzonewebrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;
import com.rpgzonewebrest.rpgzonewebrest.config.RoomConfig;

public class RoomDTO {
	private String roomID;
	private String roomNick;
	private String qtdeUsersInRoom;
	private RoomConfig roomConfig;
	private String roomDescription;
	private List<UserDTO> users = new ArrayList<UserDTO>();
	
	public RoomDTO(Room room) {
		this.setRoomID( room.getRoomID().toString() );
		this.setRoomNick(room.getRoomNick());
		this.setQtdeUsersInRoom( String.valueOf(room.getUsers().size()) );
		this.setRoomConfig( room.getRoomConfig() );
		this.setRoomDescription( room.getRoomDescription() );
		this.setUsers( usersInRoom( room.getUsers() ) );
	}
	
	private List<UserDTO> usersInRoom(List<Long> ids){
		List<UserDTO> users = new ArrayList<UserDTO>();
		DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
		for(Long id : ids) {
			users.add( new UserDTO( normalDAO.get(id) ) );
		}
		return users;
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

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
}
