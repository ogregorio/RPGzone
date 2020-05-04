package com.rpgzonewebrest.models.room;

//import java.sql.Date;

//import session.Session;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.models.user.Admin;
import com.rpgzonewebrest.models.user.User;
//import utils.Local;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin;
	private long roomID;
	private String roomNick;
	private List<Normal> users = new ArrayList<Normal>();
	private static long roomCounting = 0;
	
	public static long generateRoomID() {
		return roomCounting++;
	}
	public Room(Admin admin, long roomID, String roomNick) {
		this.admin = admin;
		this.roomID = roomID;
		this.roomNick = roomNick;
	}
	public User getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public long getID() {
		return roomID;
	}
	public void setID(long iD) {
		roomID = iD;
	}
	public String getRoomNick() {
		return roomNick;
	}
	public void setRoomNick(String roomNick) {
		this.roomNick = roomNick;
	}
	public void addUser(Normal user) {
		if(users.size() < 5) {
			users.add(user);
		}
	}
	public boolean kickUser(Normal user) {
		int index = this.users.indexOf(user);
		if(index != -1) {
			this.users.remove(index);
			return true;
		}
		return false;
	}
	/*public void newSession(Local local, Date schedule) {
		Session currentSession = new Session();
		currentSession.setLocal(local);
		currentSession.setSchedule(schedule);
	}*/
	public Object returnUserStateInRoom(User logged) {//se o usu�rio logado for o admin retorna Um objeto Admin retorna uma instancia como admin para uso dos m�todos de admin sen�o retorna Normal se encontrar ele nesta sala
		int index = this.users.indexOf(logged); 
		if(index != -1) {
			return logged.equals(this.admin) ? this.admin : users.get(index);
		}
		return null;
	}
	
	@Override
	public boolean equals(Object room) {
		return this.getID() == ( (Room) room ).getID();
	}
	
	@Override
	public String toString() {
		return "admin : " + this.admin + "\n" +
			   "room ID : " + this.roomID + "\n" +
			   "roomNick : " + this.roomNick + "\n";
	}

}
