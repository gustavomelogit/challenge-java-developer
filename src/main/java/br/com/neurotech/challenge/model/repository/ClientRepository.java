package br.com.neurotech.challenge.model.repository;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<NeurotechClient, String> {

}