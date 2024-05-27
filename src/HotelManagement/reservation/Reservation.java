package HotelManagement.reservation;

import HotelManagement.hotel.Room;
import HotelManagement.user.User;

public class Reservation {
    private ReservationStatus reservationStatus;
    private String id;
    private Room room;
    private User user;

    public Reservation( String id, Room room, User user) {
        this.reservationStatus = ReservationStatus.CONFIRMED;
        this.id = id;
        this.room = room;
        this.user = user;
    }

    public void cancelReservation(){
        if(reservationStatus == ReservationStatus.CONFIRMED){
            reservationStatus = ReservationStatus.CANCELLED;
            room.checkOut();
        }else{
            System.out.println("Reservation not confirmed");
        }
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
