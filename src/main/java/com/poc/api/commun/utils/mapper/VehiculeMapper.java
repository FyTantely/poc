package com.poc.api.commun.utils.mapper;

import java.util.List;

import com.poc.api.donnee.domaine.data.Vehicule;
import com.poc.api.donnee.dto.data.vehicule.VehiculeDTO;

public interface VehiculeMapper {

	VehiculeDTO vehiculeToDto(Vehicule vehicule);

	Vehicule DtoToVehicule(VehiculeDTO vehiculeDto);

    List<VehiculeDTO> vehiculestoDtos(List<Vehicule> vehicules);
    
    List<Vehicule> DtosToVehicules(List<VehiculeDTO> vehiculeDtos);
}
