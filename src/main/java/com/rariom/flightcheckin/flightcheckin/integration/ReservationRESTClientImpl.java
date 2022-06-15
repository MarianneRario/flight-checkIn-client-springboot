package com.rariom.flightcheckin.flightcheckin.integration;

import com.rariom.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.rariom.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRESTClientImpl implements ReservationRESTClient{

    private final String FLIGHT_REST_URL = "http://localhost:8060/flight-reservation/reservations/";

    // invoke an HTTP GET METHOD (SERVES LIKE API CALL IN POSTMAN)
    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject( FLIGHT_REST_URL + id, Reservation.class);

        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(FLIGHT_REST_URL, request, Reservation.class);

        return reservation;
    }
}
