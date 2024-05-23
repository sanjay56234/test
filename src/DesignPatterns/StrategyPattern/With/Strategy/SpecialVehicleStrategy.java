package DesignPatterns.StrategyPattern.With.Strategy;

public class SpecialVehicleStrategy implements VehicleStrategy{
    @Override
    public void drive() {
        System.out.println("Special Vehicle");
    }
}
