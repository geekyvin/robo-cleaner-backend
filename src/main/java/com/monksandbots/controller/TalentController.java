package com.monksandbots.controller;

import com.monksandbots.model.Client;
import com.monksandbots.model.Talent;
import com.monksandbots.service.ClientService;
import com.monksandbots.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/talent")
public class TalentController {


    @Autowired
    TalentService talentService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Talent talent) {
        talentService.registerTalent(talent);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
