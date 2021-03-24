package com.poc.api.commun.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.poc.api.donnee.domaine.data.Comment;
import com.poc.api.donnee.dto.data.comment.CommentDTO;

@Component
public class CommentMapperImpl implements CommentMapper {

	@Override
	public CommentDTO commentToDto(Comment comment) {
		if (Objects.isNull(comment)) {
			return null;
		}
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setUserauthentification(comment.getUserauthentification());
		commentDTO.setVehicule(comment.getVehicule());
		commentDTO.setCommentData(comment.getCommentData());
		commentDTO.setDateComment(comment.getDateComment());
		return commentDTO;
	}

	@Override
	public Comment DtoToComment(CommentDTO commentDto) {
		if (Objects.isNull(commentDto)) {
			return null;
		}
		
		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		comment.setUserauthentification(commentDto.getUserauthentification());
		comment.setVehicule(commentDto.getVehicule());
		comment.setCommentData(commentDto.getCommentData());
		comment.setDateComment(commentDto.getDateComment());
		return comment;
	}

	@Override
	public List<CommentDTO> commentstoDtos(List<Comment> comments) {
		if (CollectionUtils.isEmpty(comments)) {
			return null;
		}
		
		List<CommentDTO> list = new ArrayList<CommentDTO>(comments.size());
		for (Comment comment : comments) {
			CommentDTO commentDto = commentToDto(comment);
			list.add(commentDto);
		}

		return list;
	}

	@Override
	public List<Comment> DtosToComments(List<CommentDTO> commentDtos) {
		if (CollectionUtils.isEmpty(commentDtos)) {
			return null;
		}
		
		List<Comment> list = new ArrayList<Comment>(commentDtos.size());
		for (CommentDTO commentDto : commentDtos) {
			Comment comment = DtoToComment(commentDto);
			list.add(comment);
		}

		return list;
	}

}
