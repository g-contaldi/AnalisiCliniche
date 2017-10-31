package it.dstech.repo;

import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Paziente;

public interface PazienteRepo extends CrudRepository<Paziente, String> {

}
