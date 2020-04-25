package com.rpgzonewebrest.models.user;

//import java.sql.Date;

import com.rpgzonewebrest.models.room.Room;
//import session.Session;

public class Admin extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Admin() {
		//talvez tirar
	}
	@Override
	public void leaveRoom(long roomID) {
		System.out.println("The admin have a different implementation because if he to it are leaving of room that he created automatically the administration of room changes to other user present in room ");
	}
	public void removeRoom(long roomID) {
		System.out.println("The remove of room to admin is different because if the user leave room that he created, the room is delete of system.");
	}
	@Override
	public void addUser(Room room, Normal user) {//add user gonna success if the user is admin
		if(user.getID() != this.getID()) {
			room.addUser(user);
		}
	}
	public void setRoomNick(Room room,String nick) {
		room.setRoomNick(nick);
	}
	public boolean kickUser(Room room, Normal user) {
		return room.kickUser(user);
	}
	/*public void setSchedule(Session session,Date schedule) {
		session.setSchedule(schedule);
	}*/
	
}
