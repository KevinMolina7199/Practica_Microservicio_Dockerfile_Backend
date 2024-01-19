package com.microservice.cource.repository;

import com.microservice.cource.models.Cource;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourceRepository extends MongoRepository<Cource, String> {

    Optional<Cource> findById(String id);

    void deleteById(String courceId);

}
