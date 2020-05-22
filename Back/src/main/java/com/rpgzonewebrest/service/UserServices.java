package com.rpgzonewebrest.service;

import java.util.ArrayList;
import java.util.List;

import com.rpgzonewebrest.dao.DAO;
import com.rpgzonewebrest.dto.UserDTO;
import com.rpgzonewebrest.models.user.Normal;
import com.rpgzonewebrest.repository.DataBaseFake;



public class UserServices {
	
	private static DAO<Normal, Long> normalDAO = DataBaseFake.getUserData();
	
	public static List<UserDTO> searchUsersFilter(Normal userLogged) {
		List<Normal> list = normalDAO.getAll();
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		list.forEach( user -> {
			if(!user.equals(userLogged)) {
				listDTO.add(new UserDTO(user));
			}
		});
		return listDTO;
	}
}
