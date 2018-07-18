package com.monksandbots.controller;

import com.monksandbots.model.Query;
import com.monksandbots.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {


    @Autowired
    ContactService contactService;

    @PostMapping("/sendQuery")
    public ResponseEntity saveQuery(@RequestBody Query query) {
        contactService.saveQuery(query);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
