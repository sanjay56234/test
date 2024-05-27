package HotelManagement.hotel;

import HotelManagement.payment.Payment;
import HotelManagement.reservation.Reservation;
import HotelManagement.reservation.ReservationStatus;
import HotelManagement.user.User;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

public class HotelManagement {

    private static HotelManagement instance;
    private final Map<String, User> guests;
    private final Map<String, Room> rooms;
    private final Map<String, Reservation> reservations;

    private HotelManagement() {
        this.guests = new HashMap<>();
        this.rooms = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    public static synchronized HotelManagement getInstance(){
        if(instance==null){
            instance = new HotelManagement();
        }
        return instance;
    }

    public void addUser(User user){
        guests.put(user.getId(), user);
    }

    public User getUser(String id){
        return guests.get(id);
    }

    public void addRoom(Room room){
        rooms.put(room.getId(), room);
    }

    public void showRooms(){
        for(Map.Entry<String,Room> entry : rooms.entrySet()){
            Room room = entry.getValue();
            System.out.println(String.format(" %s : %s : %s ", room.getId(),room.getRoomType(),room.getPrice()));
        }
    }

    public Room getRoom(String id){
        return rooms.get(id);
    }

    public synchronized Reservation bookRoom(User guest, Room room) {
        if (room.getRoomStatus() == RoomStatus.AVAILABLE) {
            room.bookRoom();
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, room, guest);
            reservations.put(reservationId, reservation);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            reservation.cancelReservation();
            reservations.remove(reservationId);
        }
    }

    public synchronized void checkIn(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
            reservation.getRoom().checkIn();
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public synchronized void checkOut(String reservationId, Payment payment) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
            Room room = reservation.getRoom();
            double amount = room.getPrice();
            if (payment.makePayment(amount)) {
                room.checkOut();
                reservations.remove(reservationId);
            } else {
                throw new IllegalStateException("Payment failed.");
            }
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    private String generateReservationId() {
        // Generate a unique reservation ID
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
