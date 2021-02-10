package com.example.codeclan.whisky_galore.repositories;

import com.example.codeclan.whisky_galore.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> getByRegionIgnoreCase(String region);
}
