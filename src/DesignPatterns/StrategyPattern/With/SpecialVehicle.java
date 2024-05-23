package DesignPatterns.StrategyPattern.With;

import DesignPatterns.StrategyPattern.With.Strategy.SpecialVehicleStrategy;

public class SpecialVehicle extends Vehicle{

    SpecialVehicle(){
        super(new SpecialVehicleStrategy());
    }
}
