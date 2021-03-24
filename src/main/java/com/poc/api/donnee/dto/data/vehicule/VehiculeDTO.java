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
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String model;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mark;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private byte[] picture;
    
	public VehiculeDTO() {
	}
    
    
}
