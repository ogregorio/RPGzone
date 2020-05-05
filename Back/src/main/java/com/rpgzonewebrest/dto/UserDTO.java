package com.rpgzonewebrest.dto;

import java.text.SimpleDateFormat;

import com.rpgzonewebrest.models.user.User;

public class UserDTO {//dto é um padrão de projeto para transferência de dados entre subsistemas do inglês Data transfer object
	private String userID;
	private String nickName;
	private String email;
	private String pro;
	private String lastLogin;
	private String profilePicture;
	private String bio;
	
	public UserDTO(User user) {
		this.setUserID(user.getID().toString());
		this.setNickName(user.getNickName());
		this.setEmail(user.getEmail());
		this.setPro((user.getPro()) ? "True" : "False");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.setLastLogin(formatter.format(user.getLastLogin()));
		this.setProfilePicture(user.getProfilePicture());
		this.bio = user.getBio();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
