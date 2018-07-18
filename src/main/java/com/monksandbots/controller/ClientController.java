package com.monksandbots.controller;

import com.monksandbots.model.Client;
import com.monksandbots.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {


    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Client client) {
        clientService.registerClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
