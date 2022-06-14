package com.rariom.flightcheckin.flightcheckin.integration;

import com.rariom.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.rariom.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;

/**
 * This interface is responsible for making the web service calls
 */

public interface ReservationRESTClient {

    /**
     * @param id
     * @return Reservation
     */
    public Reservation findReservation(Long id);


    /**
     * @param request (model obj)
     * @return
     */
    public Reservation updateReservation(ReservationUpdateRequest request);
}
