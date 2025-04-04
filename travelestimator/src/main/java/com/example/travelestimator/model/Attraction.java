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
@Table(name = "attractions")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Name of the attraction
    private String location; // Location of the attraction
    private String type; // Type of attraction (e.g., museum, park, historical site)
    private Double rating; // Rating of the attraction (e.g., 4.5)
    private String description; // Brief description of the attraction
}
