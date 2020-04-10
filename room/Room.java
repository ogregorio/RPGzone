package room;

import java.sql.Date;
import java.util.ArrayList;

import session.Session;
import user.User;
import utils.Local;

public class Room {
	private User admin;
	private long roomID;
	private String roomNick;
	private ArrayList<User> users = new ArrayList<User>();
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
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
	public void addUser(User user) {
		users.add(user.getID(),user);
	}
	public boolean kickUser(int id) {
		users.remove(id);
		return true;
	}
	public void newSession(Local local, Date schedule) {
		Session currentSession = new Session();
		currentSession.setLocal(local);
		currentSession.setSchedule(schedule);
	}

}
