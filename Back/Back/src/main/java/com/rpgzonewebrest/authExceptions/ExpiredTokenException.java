package com.rpgzonewebrest.authExceptions;

import java.util.Date;

public class ExpiredTokenException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateExpiration;
	
	
	public ExpiredTokenException(Date date) {
		super("Date of token already expired in " + date + " !!! ");
		this.dateExpiration = date;
	}
	
	public Date getDateExpiration() {
		return dateExpiration;
	}
}
