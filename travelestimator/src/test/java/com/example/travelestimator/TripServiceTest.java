package com.example.travelestimator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travelestimator.model.Trip;
import com.example.travelestimator.repository.TripRepository;
import com.example.travelestimator.service.TripService;

@SpringBootTest
public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripService tripService;

    @Test
    public void testCalculateTripCost() {
        Trip mockTrip = new Trip(null, "Delhi", "Mumbai", 100.0, 1000.0, LocalDate.now());
        when(tripRepository.save(any(Trip.class))).thenReturn(mockTrip);

        Trip result = tripService.calculateTripCost("Delhi", "Mumbai", LocalDate.now());
        assertEquals(1000.0, result.getEstimatedCost());
    }
}
