package ParkingLotService.entity;

public class Vehicle {

    private String registrationNumber;
    private String color;
    private VehicleType type;

    private ParkingSlot parkingSlot;

    public Vehicle(String registrationNumber, String color, VehicleType type, ParkingSlot parkingSlot) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
        this.parkingSlot = parkingSlot;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
