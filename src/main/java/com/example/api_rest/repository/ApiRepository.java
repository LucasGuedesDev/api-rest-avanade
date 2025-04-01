package com.example.api_rest.repository;

import com.example.api_rest.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
}