package com.poc.api.donnee.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.service.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPrincipalDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String mail) {
        UserAuthentification user = userRepository.findByMail(mail);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), user.getAuthorities());
        }

        throw new UsernameNotFoundException("EMAIL OR PASSWORD.");
    }
}
