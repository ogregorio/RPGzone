package com.rpgzonewebrest.models.user;

import java.util.Date;

import javax.swing.JOptionPane;

import com.rpgzonewebrest.models.room.Room;;

public class Normal extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Normal() {
		//talvez tirar
	}
	public Normal(String nickName, String password, String email, String bio, Date lastLogin) {
		this.setPro(false);
		this.setPassword(password);
		this.setEmail(email);
		this.setNickname(nickName);
		this.setBio(bio);
		this.setLastLogin(lastLogin);
	}
	@Override
	public void leaveRoom(long roomID) {
		System.out.println("User leaves normal without to do nothing more");
	}
	@Override
	public void addUser(Room room, Normal user) {//add user gonna unsuccess if the user don't be admin
		JOptionPane.showMessageDialog(null, "User impossibility run this action because don't allowed to add users in room that you don't are administration power!!!", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
