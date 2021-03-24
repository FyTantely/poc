package com.poc.api.commun.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.dto.data.user.UserDTO;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDTO userToDto(UserAuthentification user) {
		if (Objects.isNull(user)) {
			return null;
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setLogin(user.getLogin());
		userDTO.setMail(user.getMail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

	@Override
	public UserAuthentification DtoToUser(UserDTO userDto) {
		if (Objects.isNull(userDto)) {
			return null;
		}
		
		UserAuthentification user = new UserAuthentification();
		user.setId(userDto.getId());
		user.setLogin(userDto.getLogin());
		user.setMail(userDto.getMail());
		user.setPassword(userDto.getPassword());
		return user;
	}

	@Override
	public List<UserDTO> individustoDtos(List<UserAuthentification> userAuthentifications) {
		if (CollectionUtils.isEmpty(userAuthentifications)) {
			return null;
		}
		
		List<UserDTO> list = new ArrayList<UserDTO>(userAuthentifications.size());
		for (UserAuthentification user : userAuthentifications) {
			UserDTO userDto = userToDto(user);
			list.add(userDto);
		}

		return list;
	}

}
