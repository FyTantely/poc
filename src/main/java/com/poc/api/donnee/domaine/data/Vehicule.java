package com.poc.api.donnee.domaine.data;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.bouncycastle.util.encoders.Base64;

import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@AllArgsConstructor
public class Vehicule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String model;
	private String mark;
	@Lob
	@Column(name = "picture")
	private byte[] picture;
	@OneToMany(mappedBy = "vehicule")
	Set<Comment> comment;
	
	@JsonSetter("picture")
	public void setContent(String picture) {
		try {
			this.picture = Base64.decode(picture.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
