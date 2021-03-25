package com.poc.api.donnee.dto.data.comment;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class CommentDTO {
    private Integer id;
    private Integer idUser;
    private Integer idVehicule;
    private String commentData;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateComment;
    
	public CommentDTO() {
	}
    
    

}
