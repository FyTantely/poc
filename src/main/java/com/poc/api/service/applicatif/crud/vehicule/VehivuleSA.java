package com.poc.api.service.applicatif.crud.vehicule;

import com.poc.api.donnee.dto.commun.vehicule.VehiculeListpageSuccessDto;

public interface VehivuleSA {
	
	VehiculeListpageSuccessDto findAllByPagination(Integer pageNo, Integer pageSize);

}
