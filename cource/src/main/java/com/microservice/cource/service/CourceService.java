package com.microservice.cource.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.cource.models.Cource;
import com.microservice.cource.repository.CourceRepository;

@Service
public class CourceService {

    @Autowired
    private CourceRepository couRepository;

    public List<Cource> listCource() {
        return couRepository.findAll();
    }

    public Cource create(Cource cource) {
        return couRepository.save(cource);
    }

    public String deleteCource(String courceId) {
		Optional<Cource> courceOptional = couRepository.findById(courceId);
		if (courceOptional.isPresent()) {
			couRepository.deleteById(courceId);
			return "Curso eliminado exitosamente";
		} else {
			return "Error: Curso no encontrado";
		}
	}
	
	public Optional<Cource> findById(String id) {
		return couRepository.findById(id);
	}
	
}
