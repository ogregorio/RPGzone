package user;

import java.sql.Date;

import room.Room;
import session.Session;

public class Admin{
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
