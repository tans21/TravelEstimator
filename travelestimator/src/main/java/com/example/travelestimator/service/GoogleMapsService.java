//key = AIzaSyACPESPVIImmWlw_6rlz7qxBnX7YPOHfVI

package com.example.travelestimator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GoogleMapsService {

    private static final String API_KEY = "YOUR KEY";
    private static final String URL = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=%s";

    public double getDistanceInKm(String source, String destination) {
        try {
            String url = String.format(URL, source, destination, API_KEY);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            System.out.println("Google Maps API Response: " + response);

            // Parse JSON with Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String status = root.get("status").asText();
            if (!"OK".equals(status)) {
                System.err.println("Google Maps API error: " + status);
                return 0.0;
            }

            // Directions API → distance is in routes[0].legs[0].distance.value (meters)
            JsonNode legs = root.path("routes").get(0).path("legs").get(0);
            double distanceMeters = legs.path("distance").path("value").asDouble();

            return distanceMeters / 1000.0; // convert to km

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
