package br.com.neurotech.challenge.model.service;

import org.springframework.stereotype.Service;

import br.com.neurotech.challenge.model.entity.NeurotechClient;

@Service
public interface ClientService {
	
	/**
	 * Salva um novo cliente
	 * 
	 * @return ID do cliente recém-salvo
	 */
	Long save(NeurotechClient client);
	
	/**
	 * Recupera um cliente baseado no seu ID
	 */
	NeurotechClient get(Long id);

}
