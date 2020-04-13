package user;

import java.sql.Date;

import room.Room;
import session.Session;

public class Admin extends User{
	public Admin(String email, String password, String nickname, String type, boolean pro, int userID) {
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
		this.setType(type);
		this.setPro(pro);
		this.setID(userID);
	}
	public void leaveRoom(long roomID) {
		System.out.println("The admin have a different implementation because if he to it are leaving of room that he created automatically the administration of room changes to other user present in room ");
	}
	public void removeRoom(long roomID) {
		System.out.println("The remove of room to admin is different because if the user leave room that he created, the room is delete of system.");
	}
	public void addUser(Room room, User user) {//add user gonna success if the user is admin
		if(user.getID() != this.getID()) {
			room.addUser(user);
		}
	}
	public void setRoomNick(Room room,String nick) {
		room.setRoomNick(nick);
	}
	public boolean kickUser(Room room,int id) {
		return room.kickUser(id);
	}
	public void setSchedule(Session session,Date schedule) {
		session.setSchedule(schedule);
	}
}
