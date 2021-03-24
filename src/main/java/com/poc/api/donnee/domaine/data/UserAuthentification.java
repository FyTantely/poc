package com.poc.api.donnee.domaine.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "userauthentification")
@Getter
@Setter
@AllArgsConstructor
public class UserAuthentification implements Serializable, UserDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String mail;
    @OneToMany(mappedBy = "userauthentification")
	Set<Comment> comment;
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.mail;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserAuthentification(String mail, String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

	public UserAuthentification() {
	}
	
	

}
