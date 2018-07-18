package com.monksandbots.service;

import com.monksandbots.model.Client;
import com.monksandbots.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

}
