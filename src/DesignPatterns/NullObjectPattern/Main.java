package DesignPatterns.NullObjectPattern;


public class Main {
    public static void main(String[] args) {

        VehicleInterface vehicle = VehicleFactory.getVehicleObject("Car");
        System.out.println(vehicle.getFuelCapacity());

        VehicleInterface vehicleInterface = VehicleFactory.getVehicleObject("xc");
        System.out.println(vehicleInterface.getFuelCapacity());

    }
}
