package user;

import room.Room;

public class User {
	private int userID;
	private String password;
	private String type;
	private String nickname;
	private String email;
	private Boolean pro;
	public int getID() {
		return userID;
	}
	public void setID(int iD) {
		userID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void getRoomId(Room room) {
		room.getID();
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getPro() {
		return pro;
	}
	public void setPro(Boolean premium) {
		this.pro = premium;
	}
}
