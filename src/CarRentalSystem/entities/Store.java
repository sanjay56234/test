package CarRentalSystem.entities;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;

    VehicleInventoryManagement inventoryManagement;

    Location location;

    List<Reservation> reservationList = new ArrayList<>();


    public List<Vehicle> getVehicles(VehicleType vehicleType) {

        return inventoryManagement.getVehicleList();
    }


    //addVehicles, update vehicles, use inventory management to update those.


    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {

        //take out the reservation from the list and call complete the reservation method.
        return true;
    }

}
