package com.poc.api.service.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import com.poc.api.donnee.domaine.data.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("SELECT c FROM Comment c WHERE c.vehicule.id = :idVehicule ")
    Page<Comment> findCommentByVehicule(int idVehicule, Pageable page);

}
