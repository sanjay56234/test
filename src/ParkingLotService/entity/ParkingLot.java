package ParkingLotService.entity;

import java.util.List;

public class ParkingLot {

    private String parkingLotId;
    private int floorCount;
    private int slotCount;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot(String parkingLotId, int floorCount, int slotCount) {
        this.parkingLotId = parkingLotId;
        this.floorCount = floorCount;
        this.slotCount = slotCount;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
}
