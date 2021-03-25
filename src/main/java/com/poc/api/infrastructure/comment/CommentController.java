package com.poc.api.infrastructure.comment;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.api.commun.utils.mapper.CommentMapper;
import com.poc.api.donnee.dto.commun.comment.CommentListpageSuccessDto;
import com.poc.api.donnee.dto.commun.comment.CommentSuccessDto;
import com.poc.api.donnee.dto.data.comment.CommentDTO;
import com.poc.api.service.applicatif.crud.comment.CommentSA;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/api/comment")
@RestController
public class CommentController {
	@Autowired
	CommentMapper commentMapper;
	
	@Autowired
	CommentSA commentSA;
	
	@CrossOrigin
	@ApiOperation(value = "Liste des commentaires par vehicule")
    @GetMapping( "/getListCommentVehicule")
    public ResponseEntity<CommentListpageSuccessDto> getListCommentVehicule(
    		@RequestParam(defaultValue = "0" ) Integer idVehicule,
    		@RequestParam(defaultValue = "0" ) Integer pageNo,
    		@RequestParam(defaultValue = "10" ) Integer pageSize) {
		try {
			CommentListpageSuccessDto resultList = commentSA.findAllByVehiculePagination(idVehicule, pageNo, pageSize);
			if(!Objects.isNull(resultList)) {
				return new ResponseEntity<>(resultList, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new CommentListpageSuccessDto(0, 0, 0, 0, new ArrayList<>(), "204", "Requête traitée avec succès mais pas d’information à renvoyer", "No Content"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
            return new ResponseEntity<>(new CommentListpageSuccessDto(0, 0, 0, 0, new ArrayList<>(), "500", "Internal Error", "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@ApiOperation(value = "Ajout commentaire pour une vehicule")
    @PostMapping( "/addComment")
    public ResponseEntity<CommentSuccessDto>  addComment(@RequestBody CommentDTO commentDto) throws Exception {
		CommentDTO commentAdd= commentSA.addComment(commentDto);
        
        return new ResponseEntity<>(new CommentSuccessDto(commentAdd, "200", "Succesfully done", "SUCCESS"), HttpStatus.OK);
    }

}
