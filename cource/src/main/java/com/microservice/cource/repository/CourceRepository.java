package com.microservice.cource.repository;

import com.microservice.cource.models.Cource;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourceRepository extends MongoRepository<Cource, String> {

	Optional<Cource> findById(Long id);

	void deleteById(Long courceId);
    
}
