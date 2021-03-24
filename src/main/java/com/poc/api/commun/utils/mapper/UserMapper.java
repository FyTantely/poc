package com.poc.api.commun.utils.mapper;

import java.util.List;

import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.dto.data.user.UserDTO;

public interface UserMapper {
	
	UserDTO userToDto(UserAuthentification user);

	UserAuthentification DtoToUser(UserDTO userDto);

    List<UserDTO> individustoDtos(List<UserAuthentification> userAuthentifications);

}
