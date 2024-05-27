package HotelManagement;

import HotelManagement.hotel.HotelManagement;
import HotelManagement.hotel.Room;
import HotelManagement.hotel.RoomType;
import HotelManagement.payment.CardPayment;
import HotelManagement.payment.Payment;
import HotelManagement.reservation.Reservation;
import HotelManagement.user.User;

public class Main {
    public static void main(String[] args) {
        HotelManagement hotelManagementSystem = HotelManagement.getInstance();

        // Create guests
        User guest1 = new User("G001", "John Doe");
        User guest2 = new User("G002", "Jane Smith");
        hotelManagementSystem.addUser(guest1);
        hotelManagementSystem.addUser(guest2);

        // Create rooms
        Room room1 = new Room(RoomType.SINGLE,"R001", 100.0);
        Room room2 = new Room(RoomType.DOUBLE,"R002", 200.0);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        hotelManagementSystem.showRooms();
        Reservation reservation1 = hotelManagementSystem.bookRoom(guest1, room1);
        if (reservation1 != null) {
            System.out.println("Reservation created: " + reservation1.getId());
        } else {
            System.out.println("Room not available for booking.");
        }

        // Check-in
        hotelManagementSystem.checkIn(reservation1.getId());
        System.out.println("Checked in: " + reservation1.getId());

        // Check-out and process payment
        Payment payment = new CardPayment();
        hotelManagementSystem.checkOut(reservation1.getId(), payment);
        System.out.println("Checked out: " + reservation1.getId());

        hotelManagementSystem.showRooms();
        Reservation reservation2 = hotelManagementSystem.bookRoom(guest2, room2);
        if (reservation2 != null) {
            System.out.println("Reservation created: " + reservation2.getId());
            hotelManagementSystem.cancelReservation(reservation2.getId());
            System.out.println("Reservation cancelled: " + reservation2.getId());
        }
    }
}
