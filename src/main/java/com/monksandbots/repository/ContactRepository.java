package com.monksandbots.repository;

import com.monksandbots.model.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Query, String> {

    public Query findByName(String name);

    public Query save(Query query);

}

