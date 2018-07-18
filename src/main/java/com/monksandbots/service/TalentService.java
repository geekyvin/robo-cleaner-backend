package com.monksandbots.service;

import com.monksandbots.model.Client;
import com.monksandbots.model.Talent;
import com.monksandbots.repository.ClientRepository;
import com.monksandbots.repository.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalentService {

    @Autowired
    TalentRepository talentRepository;

    public Talent registerTalent(Talent talent) {
        return talentRepository.save(talent);
    }

}
