package com.poc.api.commun.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.poc.api.donnee.domaine.data.Vehicule;
import com.poc.api.donnee.dto.data.vehicule.VehiculeDTO;

@Component
public class VehiculeMapperImpl implements VehiculeMapper {

	@Override
	public VehiculeDTO vehiculeToDto(Vehicule vehicule) {
		if (Objects.isNull(vehicule)) {
			return null;
		}
		
		VehiculeDTO vehiculeDTO = new VehiculeDTO();
		vehiculeDTO.setId(vehicule.getId());
		vehiculeDTO.setMark(vehicule.getMark());
		vehiculeDTO.setModel(vehicule.getModel());
		vehiculeDTO.setPicture(vehicule.getPicture());
		return vehiculeDTO;
	}

	@Override
	public Vehicule DtoToVehicule(VehiculeDTO vehiculeDto) {
		if (Objects.isNull(vehiculeDto)) {
			return null;
		}
		
		Vehicule vehicule = new Vehicule();
		vehicule.setId(vehiculeDto.getId());
		vehicule.setMark(vehiculeDto.getMark());
		vehicule.setModel(vehiculeDto.getModel());
		vehicule.setPicture(vehiculeDto.getPicture());
		return vehicule;
	}

	@Override
	public List<VehiculeDTO> vehiculestoDtos(List<Vehicule> vehicules) {
		if (CollectionUtils.isEmpty(vehicules)) {
			return null;
		}
		
		List<VehiculeDTO> list = new ArrayList<VehiculeDTO>(vehicules.size());
		for (Vehicule vehicule : vehicules) {
			VehiculeDTO vehiculeDto = vehiculeToDto(vehicule);
			list.add(vehiculeDto);
		}

		return list;
	}

	@Override
	public List<Vehicule> DtosToVehicules(List<VehiculeDTO> vehiculeDtos) {
		if (CollectionUtils.isEmpty(vehiculeDtos)) {
			return null;
		}
		
		List<Vehicule> list = new ArrayList<Vehicule>(vehiculeDtos.size());
		for (VehiculeDTO vehiculeDto : vehiculeDtos) {
			Vehicule vehicule = DtoToVehicule(vehiculeDto);
			list.add(vehicule);
		}

		return list;
	}

}
