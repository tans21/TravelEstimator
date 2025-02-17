package com.example.travelestimator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelestimator.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
