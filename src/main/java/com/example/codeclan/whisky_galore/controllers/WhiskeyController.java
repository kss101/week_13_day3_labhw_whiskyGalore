package com.example.codeclan.whisky_galore.controllers;

import com.example.codeclan.whisky_galore.models.Distillery;
import com.example.codeclan.whisky_galore.models.Whisky;
import com.example.codeclan.whisky_galore.repositories.DistilleryRepository;
import com.example.codeclan.whisky_galore.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskeyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhisky(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distillery", required = false) Long distillery_id,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="region", required = false) String region
    ){
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if(region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        if(distillery_id != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distillery_id, age), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhiskyById(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/whiskies")
    public ResponseEntity<Whisky> createWhisky(@RequestBody Whisky whisky){
        return new ResponseEntity<>(whiskyRepository.save(whisky), HttpStatus.CREATED);
    }
}
