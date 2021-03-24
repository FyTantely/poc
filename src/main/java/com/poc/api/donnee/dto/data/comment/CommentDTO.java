package com.poc.api.donnee.dto.data.comment;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.domaine.data.Vehicule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class CommentDTO {
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserAuthentification userauthentification;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Vehicule vehicule;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String commentData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dateComment;
    
	public CommentDTO() {
	}
    
    

}
