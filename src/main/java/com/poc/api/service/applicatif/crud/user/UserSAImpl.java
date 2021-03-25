package com.poc.api.service.applicatif.crud.user;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.api.commun.utils.mapper.UserMapper;
import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.dto.data.user.UserDTO;
import com.poc.api.service.repository.UserRepository;

@Service
public class UserSAImpl implements UserSA {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    UserMapper userMapper;

	@Override
	public UserDTO create(UserDTO userDTO) {
		return userMapper.userToDto(userRepository.save(userMapper.DtoToUser(userDTO)));
	}

	@Override
	public UserDTO findUserByMail(String mail) {
		UserAuthentification user = userRepository.findByMail(mail);
        if (!Objects.isNull(user)) {
            return userMapper.userToDto(user);
        }
        return null;
	}

}
