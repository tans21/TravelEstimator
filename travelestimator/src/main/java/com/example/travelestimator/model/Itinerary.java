package com.example.travelestimator.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "itineraries")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId; // Identifier for the user who owns this itinerary
    private LocalDate startDate; // Start date of the itinerary
    private LocalDate endDate; // End date of the itinerary
    private Double totalCost; // Total cost of the itinerary

    @OneToMany
    private List<Trip> trips; // List of trips included in the itinerary
}
