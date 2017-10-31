package it.dstech.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.dstech.model.Analiti;

public interface AnalitiRepo extends MongoRepository<Analiti, Integer> {

}
