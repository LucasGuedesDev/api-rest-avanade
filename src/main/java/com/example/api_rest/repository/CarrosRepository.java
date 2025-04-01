package com.example.api_rest.repository;

import com.example.api_rest.model.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {
}