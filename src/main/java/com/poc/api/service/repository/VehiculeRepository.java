package com.poc.api.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import com.poc.api.donnee.domaine.data.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	Page<Vehicule> findAll(Pageable page);

}
