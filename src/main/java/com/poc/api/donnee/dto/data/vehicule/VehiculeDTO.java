package com.poc.api.donnee.dto.data.vehicule;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehiculeDTO {
    private Integer id;
    private String model;
    private String mark;
    private byte[] picture;
    
	public VehiculeDTO() {
	}
    
    
}
