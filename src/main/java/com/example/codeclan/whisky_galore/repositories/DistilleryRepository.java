package com.example.codeclan.whisky_galore.repositories;

import com.example.codeclan.whisky_galore.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
