package com.poc.api.donnee.dto.commun.user;

import com.poc.api.donnee.dto.commun.CommunErrorDTO;
import com.poc.api.donnee.dto.data.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginSuccessDto extends CommunErrorDTO {
	private String token;
    private UserDTO data;

    public LoginSuccessDto(String code, String message, String token, UserDTO userLogin, boolean success) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(success);
        this.setWarning(false);
        this.setToken(token);
        this.setData(userLogin);
    }
    
}
