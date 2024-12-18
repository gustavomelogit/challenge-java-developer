package br.com.neurotech.challenge.model.exceptions;


public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String clientId) {
        super("Client with id: <{%s}> not found".formatted(clientId));
    }
}