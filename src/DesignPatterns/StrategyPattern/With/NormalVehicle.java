package DesignPatterns.StrategyPattern.With;

import DesignPatterns.StrategyPattern.With.Strategy.NormalVehicleStrategy;

public class NormalVehicle extends Vehicle {

    NormalVehicle(){
        super(new NormalVehicleStrategy());
    }

}
