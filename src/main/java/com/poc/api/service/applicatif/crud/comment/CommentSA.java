package com.poc.api.service.applicatif.crud.comment;

import com.poc.api.donnee.dto.commun.comment.CommentListpageSuccessDto;

public interface CommentSA {
	CommentListpageSuccessDto findAllByVehiculePagination(Integer idVehicule, Integer pageNo, Integer pageSize);
}
