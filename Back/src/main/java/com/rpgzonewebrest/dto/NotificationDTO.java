package com.rpgzonewebrest.dto;

import java.io.Serializable;

public class NotificationDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private SessionDTO session;
	private Long notificationID;
	private static Long notificationCounter = new Long(0);
	
	public NotificationDTO(String message, SessionDTO session) {
		this.session = session;
		this.message = message;
		this.setNotificationID( generateNotificationID() );
		
	}
	public static Long generateNotificationID() {
		notificationCounter = new Long(notificationCounter.longValue() + 1);
		return notificationCounter;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SessionDTO getSession() {
		return session;
	}
	public void setSession(SessionDTO session) {
		this.session = session;
	}
	public Long getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(Long notificationID) {
		this.notificationID = notificationID;
	}

}
