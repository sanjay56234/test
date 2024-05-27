package HotelManagement.hotel;

public class Room {

    private RoomStatus roomStatus;
    private RoomType roomType;
    private String id;
    private double price;

    public Room( RoomType roomType, String id, double price) {
        this.roomStatus = RoomStatus.AVAILABLE;
        this.roomType = roomType;
        this.id = id;
        this.price = price;
    }

    public void bookRoom(){
        if(roomStatus == RoomStatus.AVAILABLE){
            this.roomStatus = RoomStatus.BOOKED;
        }else{
            System.out.println("Room not available");
        }
    }

    public void checkIn(){
        if(roomStatus == RoomStatus.BOOKED){
            this.roomStatus = RoomStatus.OCCUPIED;
        }else{
            System.out.println("Room not booked");
        }
    }

    public void checkOut(){
        if(roomStatus == RoomStatus.OCCUPIED){
            this.roomStatus = RoomStatus.AVAILABLE;
        }else{
            System.out.println("Room not occupied");
        }
    }
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
