package com.example.codeclan.whisky_galore.controllers;

import com.example.codeclan.whisky_galore.models.Distillery;
import com.example.codeclan.whisky_galore.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }
}
