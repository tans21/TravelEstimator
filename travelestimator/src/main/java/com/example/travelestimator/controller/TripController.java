package com.example.travelestimator.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelestimator.model.Trip;
import com.example.travelestimator.service.TripService;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/calculate")
    public ResponseEntity<Trip> calculateTrip(@RequestParam String source, @RequestParam String destination, @RequestParam String date) {        
        LocalDate tripDate = LocalDate.parse(date);
        Trip trip = tripService.calculateTripCost(source, destination, tripDate);
        return ResponseEntity.ok(trip);
    }

}
