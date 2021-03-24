package com.poc.api.service.applicatif.crud.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poc.api.commun.utils.mapper.CommentMapper;
import com.poc.api.donnee.domaine.data.Comment;
import com.poc.api.donnee.dto.commun.comment.CommentListpageSuccessDto;
import com.poc.api.service.repository.CommentRepository;

@Service
public class CommentSAImpl implements CommentSA {
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	CommentMapper commentMapper;

	@Override
	public CommentListpageSuccessDto findAllByVehiculePagination(Integer idVehicule, Integer pageNo, Integer pageSize) {
		Pageable paging = pageSize == null ? Pageable.unpaged() : PageRequest.of(pageNo, pageSize);
		Page<Comment> pagedResult = commentRepository.findCommentByVehicule(idVehicule, paging);
		if (pagedResult.hasContent()) {
			return new CommentListpageSuccessDto(0, pagedResult.getTotalElements(), pageNo, pagedResult.getTotalPages(), commentMapper.commentstoDtos(pagedResult.getContent()), "200", "Succesfully done", "SUCCESS");
		} else {
			return null;
		}
	}

}
