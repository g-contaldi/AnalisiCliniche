package it.dstech.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.dstech.model.Paziente;

public interface PazienteRepo extends MongoRepository<Paziente, String> {

}
