package br.com.neurotech.challenge.model.repository;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<NeurotechClient, Long> {

}