package com.poc.api.commun.utils.mapper;

import java.util.List;

import com.poc.api.donnee.domaine.data.Comment;
import com.poc.api.donnee.dto.data.comment.CommentDTO;

public interface CommentMapper {
	
	CommentDTO commentToDto(Comment comment);

	Comment DtoToComment(CommentDTO commentDto);

    List<CommentDTO> commentstoDtos(List<Comment> comments);
    
    List<Comment> DtosToComments(List<CommentDTO> commentDtos);

}
