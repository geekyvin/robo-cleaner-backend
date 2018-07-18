package com.monksandbots.service;

import com.monksandbots.model.Query;
import com.monksandbots.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Query saveQuery(Query query) {
        return contactRepository.save(query);
    }

}
