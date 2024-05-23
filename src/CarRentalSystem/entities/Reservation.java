package CarRentalSystem.entities;

import CarRentalSystem.Product.Vehicle;

import java.util.Date;

public class Reservation {
    int id;
    Vehicle vehicle;
    Date bookingDate;
    Location drop;
    Location pickup;
    User user;

    ReservationType reservationType;
    ReservationStatus reservationStatus;


    public int createReserve(User user, Vehicle vehicle){

        //generate new id
        id = 12232;
        this.user=user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;

        return id;
    }

}
