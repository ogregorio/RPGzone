package com.rpgzonewebrest.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.models.user.User;

class NormalDAOTest {
	public static NormalDAO normalDAO;
	public static Normal userAux;
	@BeforeAll
	public static void init() {
		( new File("users.dat") ).delete();
		User.setUserCounting(new Long(0));
		normalDAO = new NormalDAO();
		userAux = new Normal("User", "User", "user@gmail.com", "I am user", new Date(System.currentTimeMillis()) );
		normalDAO.add(userAux);
	}
	@Test
	public void testAdd() {
		Normal user = new Normal("User2", "User2", "user2@gmail.com", "I am user2", new Date(System.currentTimeMillis()) );
		normalDAO.add(user);
	    assertTrue(normalDAO.getAll().indexOf(user) != -1,  "User Not Found");
	}
	@Test
	public void testGet() {
		assertEquals(normalDAO.get(new Long(1)), userAux, "User not Found" );
	}
	@Test
	public void testGetAll() {
		assertTrue(normalDAO.getAll().indexOf(userAux) != -1, "List Not Found");
	}
	@Test
	public void testUpdate() {
		Normal user = normalDAO.get(new Long(1));
		user.setEmail("EmailChanged@gmail.com");
		normalDAO.update(user);
		assertEquals(normalDAO.get(new Long(1)), user, "Update not functioned");
	}
	@Test
	public void testDelete() {
		Normal user = new Normal("User3", "User3", "user3@gmail.com", "I am user3", new Date(System.currentTimeMillis()) );
		normalDAO.add(user);
		normalDAO.delete(user);
		assertEquals(-1, normalDAO.getAll().indexOf(user), "this list could't have these items");
		
	}
	
}
