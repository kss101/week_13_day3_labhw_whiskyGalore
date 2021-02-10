package com.example.codeclan.whisky_galore.repositories;

import com.example.codeclan.whisky_galore.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}
