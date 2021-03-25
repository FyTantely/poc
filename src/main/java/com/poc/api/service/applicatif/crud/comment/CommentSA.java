package com.poc.api.service.applicatif.crud.comment;

import com.poc.api.donnee.dto.commun.comment.CommentListpageSuccessDto;
import com.poc.api.donnee.dto.data.comment.CommentDTO;

public interface CommentSA {
	CommentListpageSuccessDto findAllByVehiculePagination(Integer idVehicule, Integer pageNo, Integer pageSize);
	
	CommentDTO addComment(CommentDTO commentDto);
}
