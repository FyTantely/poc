package com.poc.api.donnee.dto.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String login;
    private String mail;
    private String Password;
    
    public UserDTO() {
    }

}
