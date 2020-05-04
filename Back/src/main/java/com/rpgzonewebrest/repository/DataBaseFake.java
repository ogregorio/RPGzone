package com.rpgzonewebrest.repository;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dao.NormalDAO;
import com.rpgzonewebrest.models.user.Normal;

public class DataBaseFake {
	private static DAO<Normal, Long> userData = new NormalDAO();
	
	public static DAO<Normal, Long> getUserData(){
		return userData;
	}
}
