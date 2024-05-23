package ParkingLotService.database;

import ParkingLotService.entity.ParkingFloor;
import ParkingLotService.entity.ParkingSlot;
import ParkingLotService.entity.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepo {


    public List<ParkingFloor> createParkingFloor(int floor, int slot){
        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i=0;i<floor;i++){
            List<ParkingSlot> parkingSlots = createParkingFloorSlot(slot, i+1);
            parkingFloors.add(new ParkingFloor(parkingSlots));
        }
        return parkingFloors;
    }

    private List<ParkingSlot> createParkingFloorSlot(int slot, int floor){
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for(int i=1;i<=slot;i++){
            if(i<=1){
                parkingSlots.add(getTruckSlot(i,floor));
            }else if(i<=3){
                parkingSlots.add(getCarSlot(i,floor));
            }else {
                parkingSlots.add(getBikeSlot(i,floor));
            }
        }
        return parkingSlots;
    }

    private ParkingSlot getTruckSlot(int slotId, int floor){
        return new ParkingSlot(floor, slotId, true, VehicleType.TRUCK);
    }

    private ParkingSlot getBikeSlot(int slotId, int floor){
        return new ParkingSlot(floor, slotId, true, VehicleType.BIKE);
    }

    private ParkingSlot getCarSlot(int slotId, int floor){
        return new ParkingSlot(floor, slotId, true, VehicleType.CAR);
    }
}
