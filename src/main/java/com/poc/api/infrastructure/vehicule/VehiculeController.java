package com.poc.api.infrastructure.vehicule;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.api.commun.utils.mapper.VehiculeMapper;
import com.poc.api.donnee.dto.commun.vehicule.VehiculeListpageSuccessDto;
import com.poc.api.service.applicatif.crud.vehicule.VehivuleSA;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/api/vehicule")
@RestController
public class VehiculeController {
	@Autowired
	VehiculeMapper vehiculeMapper;
	
	@Autowired
	VehivuleSA vehiculeSA;
	
	@CrossOrigin
	@ApiOperation(value = "Liste des vehicules")
    @GetMapping( "/getListVehicule")
    public ResponseEntity<VehiculeListpageSuccessDto> getListVehicule(
    		@RequestParam(defaultValue = "0" ) Integer pageNo,
    		@RequestParam(defaultValue = "10" ) Integer pageSize) {
		try {
			VehiculeListpageSuccessDto resultList = vehiculeSA.findAllByPagination(pageNo, pageSize);
			if(!Objects.isNull(resultList)) {
				return new ResponseEntity<>(resultList, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new VehiculeListpageSuccessDto(0, 0, 0, 0, new ArrayList<>(), "204", "Requête traitée avec succès mais pas d’information à renvoyer", "No Content"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
            return new ResponseEntity<>(new VehiculeListpageSuccessDto(0, 0, 0, 0, new ArrayList<>(), "500", "Internal Error", "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
