package com.rpgzonewebrest.dto;

import java.io.Serializable;

public class InviteDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long roomID;
	
	public SessionDTO getSession() { return null; }
	
	public InviteDTO(Long roomID) {
		setRoomID(roomID);
	}

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}
}
