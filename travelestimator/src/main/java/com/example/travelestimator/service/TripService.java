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

    public Trip calculateTripCost(String source, String destination, LocalDate tripDate) {
        double distance = getDistanceFromAPI(source, destination);
        double costPerKm = 10.0;
        double estimatedCost = distance * costPerKm;
        
        Trip trip = new Trip(null, source, destination, estimatedCost, estimatedCost, tripDate);
        return tripRepository.save(trip);
    }

    private double getDistanceFromAPI(String source, String destination){
        return 100.0;
    }

}
