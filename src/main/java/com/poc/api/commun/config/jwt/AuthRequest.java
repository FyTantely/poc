package com.poc.api.commun.config.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
	private String mail;
    private String password;

}
