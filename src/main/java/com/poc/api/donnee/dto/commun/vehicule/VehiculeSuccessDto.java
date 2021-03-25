package com.poc.api.donnee.dto.commun.vehicule;

import com.poc.api.donnee.dto.commun.CommunErrorDTO;
import com.poc.api.donnee.dto.data.vehicule.VehiculeDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculeSuccessDto extends CommunErrorDTO {
	
	private VehiculeDTO data;
    private String code;
    private String message;
    private String success;

    public VehiculeSuccessDto(VehiculeDTO vehiculeDTO, String code, String message, String success) {
        this.setCode(code);
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(vehiculeDTO);
    }

}
