package com.example.codeclan.whisky_galore.controllers;

import com.example.codeclan.whisky_galore.models.Distillery;
import com.example.codeclan.whisky_galore.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name="region", required = false) String region,
            @RequestParam(name="whiskyAge", required = false) Integer age
    ){
        if(region != null){
            return new ResponseEntity<>(distilleryRepository.getByRegionIgnoreCase(region), HttpStatus.OK);
        }
        if(age != null){
            return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistilleryById(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/distilleries")
    public ResponseEntity<Distillery> createDistillery(@RequestBody Distillery distillery){
        return new ResponseEntity<>(distilleryRepository.save(distillery), HttpStatus.CREATED);
    }
}
