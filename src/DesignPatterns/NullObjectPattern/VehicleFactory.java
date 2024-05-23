package DesignPatterns.NullObjectPattern;

public class VehicleFactory {

    public static VehicleInterface getVehicleObject(String vehicleType){

        if(vehicleType.equals("Car"))
        {
            return new Car();
        }

        return new NullObject();

    }

}
