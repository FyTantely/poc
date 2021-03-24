package com.poc.api.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.api.donnee.domaine.data.UserAuthentification;

public interface UserRepository extends JpaRepository<UserAuthentification, Integer> {
	UserAuthentification findByLogin(String login);
	

}
