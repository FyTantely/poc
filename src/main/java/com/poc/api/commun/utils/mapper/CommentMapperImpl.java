package com.poc.api.commun.utils.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.api.donnee.domaine.data.Comment;
import com.poc.api.donnee.domaine.data.UserAuthentification;
import com.poc.api.donnee.domaine.data.Vehicule;
import com.poc.api.donnee.dto.data.comment.CommentDTO;
import com.poc.api.service.repository.UserRepository;
import com.poc.api.service.repository.VehiculeRepository;

@Component
public class CommentMapperImpl implements CommentMapper {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VehiculeRepository vehiculeRepository;

	@Override
	public CommentDTO commentToDto(Comment comment) {
		if (Objects.isNull(comment)) {
			return null;
		}
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setIdUser(comment.getUserauthentification().getId());
		commentDTO.setIdVehicule(comment.getVehicule().getId());
		commentDTO.setCommentData(comment.getCommentData());
		
		try {
			LocalDate dateComment = Instant.ofEpochMilli(comment.getDateComment().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			commentDTO.setDateComment(LocalDate.parse(dateComment.format(formatter), formatter));
		}catch (Exception e) {
			commentDTO.setDateComment(LocalDate.now());
		}
		return commentDTO;
	}

	@Override
	public Comment DtoToComment(CommentDTO commentDto) {
		if (Objects.isNull(commentDto)) {
			return null;
		}
		
		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		Optional<UserAuthentification> user = userRepository.findById(commentDto.getIdUser());
		if(user.isPresent()) {
			comment.setUserauthentification(user.get());
		}
		
		Optional<Vehicule> vehicule = vehiculeRepository.findById(commentDto.getIdVehicule());
		if(vehicule.isPresent()) {
			comment.setVehicule(vehicule.get());
		}
		
		comment.setCommentData(commentDto.getCommentData());
		try {
			comment.setDateComment(Date.from(commentDto.getDateComment().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		}catch (Exception e) {
			comment.setDateComment(new Date());
		}
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
