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
		System.out.println("The control of rooms is passed to another User.");
	}
	public void removeRoom(long roomID) {
		System.out.println("The room will be deleted");
	}
	public void addUser(Room room, User user) {//adicionar usuario e bem sucedido se feito por um admin
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
