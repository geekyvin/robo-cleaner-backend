package com.mashmellow.controller;

import com.mashmellow.exception.OutTheGridException;
import com.mashmellow.model.CleanerInfo;
import com.mashmellow.model.GridInformation;
import com.mashmellow.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/robot")
public class RobotController {

    @Autowired
    RobotService robotService;

    @PostMapping("/clean")
    public ResponseEntity register(@RequestBody GridInformation gridInformation) {
        CleanerInfo cleanerInfo;
        try {
            cleanerInfo = robotService.clean(gridInformation);
        } catch (OutTheGridException e) {
            //log the error
            //e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid Input!");

        }
        return ResponseEntity.ok(cleanerInfo);
    }

}
