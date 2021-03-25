package com.poc.api.service.applicatif.crud.vehicule;

import com.poc.api.donnee.dto.commun.vehicule.VehiculeListpageSuccessDto;
import com.poc.api.donnee.dto.data.vehicule.VehiculeDTO;

public interface VehivuleSA {
	
	VehiculeListpageSuccessDto findAllByPagination(Integer pageNo, Integer pageSize);
	
	VehiculeDTO findById(Integer id);

}
