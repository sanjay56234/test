package ParkingLotService.entity;

public class ParkingSlot {

    private int floorNumber;
    private int slotId;
    boolean free;

    private VehicleType vehicleType;

    public ParkingSlot(int floorNumber, int slotId, boolean free, VehicleType vehicleType) {
        this.floorNumber = floorNumber;
        this.slotId = slotId;
        this.free = free;
        this.vehicleType = vehicleType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
