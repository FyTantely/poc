package com.poc.api.donnee.dto.commun.comment;

import com.poc.api.donnee.dto.commun.CommunErrorDTO;
import com.poc.api.donnee.dto.data.comment.CommentDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentSuccessDto extends CommunErrorDTO {
	
	private CommentDTO data;
    private String code;
    private String message;
    private String success;

    public CommentSuccessDto(CommentDTO commentDTO, String code, String message, String success) {
        this.setCode(code);
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(commentDTO);
    }
}
