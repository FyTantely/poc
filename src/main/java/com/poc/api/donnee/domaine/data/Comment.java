package com.poc.api.donnee.domaine.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	@ManyToOne
	private UserAuthentification userauthentification;
	@ManyToOne
	private Vehicule vehicule;
	private String commentData;
	private Date dateComment;
	
	public Comment() {
		super();
	}
	
	

}
