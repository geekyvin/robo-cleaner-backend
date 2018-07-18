package com.monksandbots.repository;

import com.monksandbots.model.Talent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalentRepository extends MongoRepository<Talent, String> {

    public Talent findByName(String firstName);

    public Talent save(Talent talent);

}

