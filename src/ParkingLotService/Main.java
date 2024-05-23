package ParkingLotService;

import ParkingLotService.entity.Command;
import ParkingLotService.entity.DisplayType;
import ParkingLotService.entity.ParkingLot;
import ParkingLotService.entity.VehicleType;
import ParkingLotService.service.ParkingLotService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         ParkingLotService parkingLotService  = new ParkingLotService();
         while (true){
             Scanner scanner = new Scanner(System.in);
             Command command = Command.of(scanner.next());

             switch (command){
                 case CREATE_PARKING_LOT:
                     parkingLotService.createParkingLot(new ParkingLot(scanner.next(),scanner.nextInt(),scanner.nextInt()));
                     break;
                 case PARK_VEHICLE:
                     parkingLotService.parkVehicle(VehicleType.valueOf(scanner.next()), scanner.next(), scanner.next());
                     break;
                 case UNPARK_VEHICLE:
                     parkingLotService.unparkVehicle(scanner.next());
                     break;
                 case DISPLAY:
                     parkingLotService.display(DisplayType.of(scanner.next()), VehicleType.valueOf(scanner.next()));
                     break;
                 case EXIT:
                     return;
             }
         }
    }
}
