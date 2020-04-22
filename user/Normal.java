package user;

import javax.swing.JOptionPane;

import room.Room;

public class Normal extends User{
	public Normal(String email, String password, String nickname, String type, boolean pro, int userID) {
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
		this.setType(type);
		this.setPro(pro);
		this.setID(userID);
	}
	public void leaveRoom(long roomID) {
		System.out.println("User leaves normal without to do nothing more");
	}
	public void addUser(Room room, User user) {//add user gonna unsuccess if the user don't be admin
		JOptionPane.showMessageDialog(null, "User impossibility run this action because don't allowed to add users in room that you don't are administration power!!!", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
