package com.example.travelestimator.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.travelestimator.model.Trip;
import com.example.travelestimator.service.TripService;

import lombok.Data;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "*") // allow frontend (React) calls
public class TripController {

    @Autowired
    private TripService tripService;

    /**
     * Endpoint to calculate trip distance and cost
     * Example:
     * POST /api/trips/calculate?source=Delhi&destination=Jaipur&date=2025-09-10
     */
    @PostMapping("/calculate")
    public ResponseEntity<Trip> calculateTrip(
        @RequestParam String source,
        @RequestParam String destination,
        @RequestParam String date
    ) {
        LocalDate tripDate = LocalDate.parse(date.trim()); // 👈 Trim removes \n, spaces
        Trip trip = tripService.calculateTripCost(source, destination, tripDate);
        return ResponseEntity.ok(trip);
    }

}
