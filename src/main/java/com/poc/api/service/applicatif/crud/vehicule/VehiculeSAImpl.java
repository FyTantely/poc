package com.poc.api.service.applicatif.crud.vehicule;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poc.api.commun.utils.mapper.VehiculeMapper;
import com.poc.api.donnee.domaine.data.Vehicule;
import com.poc.api.donnee.dto.commun.vehicule.VehiculeListpageSuccessDto;
import com.poc.api.donnee.dto.data.vehicule.VehiculeDTO;
import com.poc.api.service.repository.VehiculeRepository;

@Service
public class VehiculeSAImpl implements VehivuleSA {
	@Autowired
	VehiculeRepository vehiculeRepository;
	
	@Autowired
	VehiculeMapper vehicuelMapper;

	@Override
	public VehiculeListpageSuccessDto findAllByPagination(Integer pageNo, Integer pageSize) {
		Pageable paging = pageSize == null ? Pageable.unpaged() : PageRequest.of(pageNo, pageSize);
		Page<Vehicule> pagedResult = vehiculeRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return new VehiculeListpageSuccessDto(0, pagedResult.getTotalElements(), pageNo, pagedResult.getTotalPages(), vehicuelMapper.vehiculestoDtos(pagedResult.getContent()), "200", "Succesfully done", "SUCCESS");
		} else {
			return null;
		}
	}

	@Override
	public VehiculeDTO findById(Integer id) {
		Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            return vehicuelMapper.vehiculeToDto(vehicule.get());
        } else {
            return null;
        }
	}
	
}
