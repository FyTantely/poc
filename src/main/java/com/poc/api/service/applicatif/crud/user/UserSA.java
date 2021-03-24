package com.poc.api.service.applicatif.crud.user;

import com.poc.api.donnee.dto.data.user.UserDTO;

public interface UserSA {
	UserDTO create(UserDTO userDTO);
	
	UserDTO findUserByMail(String mail);
}
