package ParkingLotService.service;

import ParkingLotService.database.DatabaseRepo;
import ParkingLotService.entity.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {

    private Map<String, Vehicle> vehicleMap;

    private ParkingLot parkingLot;
    private DatabaseRepo databaseRepo;


    public void createParkingLot(ParkingLot parkingLot){
        vehicleMap = new HashMap<>();
        this.parkingLot = parkingLot;
        databaseRepo = new DatabaseRepo();
        parkingLot.setParkingFloorList(databaseRepo.createParkingFloor(parkingLot.getFloorCount(), parkingLot.getSlotCount()));
        System.out.println("Created parking lot with "+ parkingLot.getFloorCount()+
                "floors and "+parkingLot.getSlotCount()+" slots per floor");
    }

    public void parkVehicle(VehicleType vehicleType, String registrationNumber, String color){
        ParkingSlot parkingSlot = checkAvailableSlot(vehicleType);
        if(parkingSlot == null){
            System.out.println("No available slots");
        }else{
            parkingSlot.setFree(false);
            String ticketId = generateTicketId(parkingSlot, registrationNumber);
            Vehicle vehicle = new Vehicle(registrationNumber, color, vehicleType, parkingSlot);
            vehicleMap.put(ticketId, vehicle);
            System.out.println("Parked vehicle. Ticket ID: "+ ticketId);

        }
    }

    public void unparkVehicle(String ticketId){
        if(vehicleMap.containsKey(ticketId)){
            Vehicle vehicle = vehicleMap.get(ticketId);
            ParkingSlot parkingSlot = vehicle.getParkingSlot();
            parkingSlot.setFree(true);
            vehicleMap.remove(ticketId);
            System.out.println("Unparked vehicle with Registration Number:"+vehicle.getRegistrationNumber()+
                    "and Color:"+ vehicle.getColor());
        }else{
            System.out.println("Invalid Ticket ID");
        }
    }

    private String generateTicketId(ParkingSlot parkingSlot, String registration){
        return parkingLot.getParkingLotId() + "_" + parkingSlot.getFloorNumber() + "_" + parkingSlot.getSlotId();
    }

    private ParkingSlot checkAvailableSlot(VehicleType vehicleType){
        ParkingSlot freeParkingSlot = null;
        for(ParkingFloor parkingFloor : this.parkingLot.getParkingFloorList()){
            List<ParkingSlot> parkingSlots = getAvailableVehicleTypeParkingSlot(parkingFloor.getParkingSlotList(), vehicleType);
            for(ParkingSlot parkingSlot : parkingSlots){
                if(parkingSlot.isFree()){
                    freeParkingSlot = parkingSlot;
                    break;
                }
            }
        }
        return freeParkingSlot;
    }

    private List<ParkingSlot> getAvailableVehicleTypeParkingSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.TRUCK) && parkingSlots.size()>=1) {
            return Arrays.asList(parkingSlots.get(0));
        }else if(vehicleType.equals(VehicleType.CAR) && parkingSlots.size()>=3) {
            return Arrays.asList(parkingSlots.get(1),parkingSlots.get(2));
        }
        else{
            return parkingSlots;
        }
    }


    public void display(DisplayType displayType, VehicleType vehicleType){
        if(displayType == DisplayType.FREE_COUNT){
            displayFreeCounts(vehicleType);
        }else if(displayType == DisplayType.FREE_SLOTS){
            displayFreeSlots(vehicleType);
        }else{
            displayOccupiedCounts(vehicleType);
        }
    }

    private void displayFreeCounts(VehicleType vehicleType){
        for(int i=0;i<parkingLot.getParkingFloorList().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);

            long count = parkingFloor.getParkingSlotList().stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType)).filter(ParkingSlot::isFree).count();
            System.out.println(" No. of free slots for " +vehicleType+" on Floor "+ (i+1) +" :"+ count);
        }
    }

    private void displayFreeSlots(VehicleType vehicleType){
        for(int i=0;i<parkingLot.getParkingFloorList().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);

            List<ParkingSlot>parkingSlots = parkingFloor.getParkingSlotList().stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType)).filter(ParkingSlot::isFree).collect(Collectors.toList());
            StringBuilder printStatement = new StringBuilder("Free slots for " + vehicleType + " on Floor " + (i+1) + " :");
            for(ParkingSlot parkingSlot : parkingSlots){
                printStatement.append(parkingSlot.getSlotId()).append(" ,");
            }
            System.out.println(printStatement);
        }
    }

    private void displayOccupiedCounts(VehicleType vehicleType){
        for(int i=0;i<parkingLot.getParkingFloorList().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlotList()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(parkingSlot -> !parkingSlot.isFree()).collect(Collectors.toList());
            StringBuilder printStatement = new StringBuilder("Occupied slots for " + vehicleType + " on Floor " +(i+1) + " :");
            for (ParkingSlot parkingSlot : collect) {
                printStatement.append(parkingSlot.getSlotId() + 1);
                printStatement.append(",");
            }
            System.out.println(printStatement);
        }
    }

}
