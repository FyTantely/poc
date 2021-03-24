package com.poc.api.donnee.dto.commun.user;

import com.poc.api.donnee.dto.commun.CommunErrorDTO;
import com.poc.api.donnee.dto.data.user.UserDTO;

public class LoginSuccessDto extends CommunErrorDTO {
	private String token;
    private UserDTO data;

    public LoginSuccessDto(String code, String message, String token, UserDTO userLogin) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(true);
        this.setWarning(false);
        this.setToken(token);
        this.setData(userLogin);
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getData() {
        return data;
    }

    public void setData(UserDTO data) {
        this.data = data;
    }
}
