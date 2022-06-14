package com.rariom.flightcheckin.flightcheckin.Controllers;

import com.rariom.flightcheckin.flightcheckin.integration.ReservationRESTClient;
import com.rariom.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.rariom.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    private ReservationRESTClient reservationRESTClient;

    @RequestMapping(path = "/showStartCheckIn")
    protected String showStartCheckIn(){
        System.out.println("here");
        return "startCheckIn";
    }

    @RequestMapping(path = "/startCheckIn", method = RequestMethod.POST)
    protected String startCheckIn(// @RequestParam value SHOULD be the same with the "name" in our html
                                  @RequestParam("reservationId") Long reservationId,
                                  ModelMap modelMap){
        // retrieve the reservation for the "reservationId" from the ReservationRESTClient
        Reservation reservation = reservationRESTClient.findReservation(reservationId);
        // the value of the "reservation" should be sent to the next page
        modelMap.addAttribute("reservation", reservation); // contains the reservation object

        return "displayReservationDetails";
    }

    @RequestMapping(path = "completeCheckIn", method = RequestMethod.POST)
    protected String completeCheckIn(
            @RequestParam("reservationId") Long reservationId,
            @RequestParam("numberOfBags") int numberOfBags){

        ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setNumberOfBags(numberOfBags);
        request.setCheckedIn(true);

        reservationRESTClient.updateReservation(request); // pass a whole object

        return "checkInConfirmation";
    }
}









