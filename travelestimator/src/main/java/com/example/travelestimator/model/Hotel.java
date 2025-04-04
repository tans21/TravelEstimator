package com.example.travelestimator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Name of the hotel
    private String location; // Location of the hotel
    private Double pricePerNight; // Price per night for a stay
    private Double rating; // Rating of the hotel (e.g., 4.5)
    private String amenities; // Amenities offered by the hotel (e.g., WiFi, Pool)
}
