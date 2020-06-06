package com.rpgzonewebrest.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rpgzonewebrest.models.room.Room;
import com.rpgzonewebrest.models.user.Admin;

class RoomDAOTest {
	public static RoomDAO roomDAO;
	public static Room roomAux;
	@BeforeAll
	public static void init() {
		( new File("rooms.dat") ).delete();
		Room.setRoomCounting(new Long(0));
		roomDAO = new RoomDAO();
		roomAux = new Room(new Admin(), "Room", "Description");;
		roomDAO.add(roomAux);
	}
	@Test
	public void testAdd() {
		Room room = new Room(new Admin(), "Room1", "Description1");
		roomDAO.add(room);
	    assertTrue(roomDAO.getAll().indexOf(room) != -1,  "Room Not Found");
	}
	@Test
	public void testGet() {
		assertEquals(roomDAO.get(new Long(1)), roomAux, "User not Found" );
	}
	@Test
	public void testGetAll() {
		assertTrue(roomDAO.getAll().indexOf(roomAux) != -1, "List Not Found");
	}
	@Test
	public void testUpdate() {
		Room room = roomDAO.get(new Long(1));
		room.setRoomNick("RoomNickChanged");
		roomDAO.update(room);
		assertEquals(roomDAO.get(new Long(1)), room, "Update not functioned");
	}
	@Test
	public void testDelete() {
		Room room = new Room(new Admin(), "Room3", "Description3");
		roomDAO.add(room);
		roomDAO.delete(room);
		assertEquals(-1, roomDAO.getAll().indexOf(room), "this list could't have these items");
		
	}
	
}
