package com.poc.api.service.applicatif.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poc.api.commun.utils.mapper.UserMapper;
import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.dto.data.user.UserDTO;
import com.poc.api.service.repository.UserRepository;

@Service
public class UserSAImpl implements UserSA {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
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
		UserAuthentification user = userRepository.findByLogin(mail);
        if (user != null) {
            return userMapper.userToDto(user);
        }
        return null;
	}

}
