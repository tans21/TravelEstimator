package com.example.travelestimator.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelestimator.model.Trip;
import com.example.travelestimator.repository.TripRepository;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private GoogleMapsService googleMapsService;  // service to fetch distance from API

    /**
     * Calculates trip distance and cost, then saves to DB.
     */
    public Trip calculateTripCost(String source, String destination, LocalDate tripDate) {
        // Step 1: Get distance from Google Directions API
        double distance = googleMapsService.getDistanceInKm(source, destination);

        // Step 2: Apply cost calculation rule
        double costPerKm = 10.0; // later you can move this to config
        double estimatedCost = distance * costPerKm;

        // Step 3: Create Trip entity
        Trip trip = new Trip(
            null,          // id → auto-generated
            source, 
            destination, 
            distance,      // store distance (km)
            estimatedCost, // store calculated cost
            tripDate
        );

        // Step 4: Persist in DB
        return tripRepository.save(trip);
    }
}
