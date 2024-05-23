package DesignPatterns.StrategyPattern.With;

import DesignPatterns.StrategyPattern.With.Strategy.VehicleStrategy;

public class Vehicle {

    private VehicleStrategy vehicleStrategy;

    Vehicle(VehicleStrategy vehicleStrategy){
        this.vehicleStrategy = vehicleStrategy;
    }

    public void drive(){
        vehicleStrategy.drive();
    }

}
