package com.rpgzonewebrest.service;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;

import java.util.Iterator;
import java.util.List;

public class AuthServices {
	
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static String encrypt(String input) {
		return "test";
	}
	public static  boolean registeredOnDB(Normal user) {
		List<Normal> users = normalDAO.getAll();
		Normal userOnDB = null;
		for(Iterator<Normal> iterator = users.iterator(); iterator.hasNext();) {
			userOnDB = (Normal) iterator.next();
			if( user.getUserName().equals(userOnDB.getUserName())  && user.getPassword().equals(userOnDB.getPassword()) ) {
				return true;
			}
		}
		return false;
	}
}
