package room;

import java.sql.Date;
import java.util.ArrayList;

import session.Session;
import user.User;
import utils.Local;
import java.util.Iterator;

public class Room {
	private User admin;
	private long roomID;
	private String roomNick;
	private ArrayList<User> users = new ArrayList<User>();
	private static long roomCounting = 0;
	
	public static long generateRoomID() {
		return roomCounting++;
	}
	public Room(User admin, long roomID, String roomNick) {
		this.admin = admin;
		this.roomID = roomID;
		this.roomNick = roomNick;
	}
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
		if(users.size() < 5) {
			users.add(user);
		}
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
	public Object returnUserStateInRoom(User logged) {
		Object response = null;
		User userInRoom;
		for(Iterator<User> iterator = this.users.iterator(); response == null && iterator.hasNext();) {
			userInRoom = (User) iterator.next();
			if(logged.getID() ==  userInRoom.getID() ) {
				response = userInRoom;
			}
		}
		return response;
	}
	
	@Override
	public String toString() {
		String users = "";
		for(Iterator<User> iterator = this.users.iterator(); iterator.hasNext();) {
			users += iterator.next() + "\n";
		}
		
		return "admin : " + this.admin + "\n" +
			   "room ID : " + this.roomID + "\n" +
			   "roomNick : " + this.roomNick + "\n" +
			   "Users inside room => \n"+
			   users;
	}

}
