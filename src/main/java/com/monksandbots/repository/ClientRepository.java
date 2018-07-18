package com.monksandbots.repository;

import com.monksandbots.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

    public Client findByName(String firstName);

    public Client save(Client client);

}

