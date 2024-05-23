package DesignPatterns.StrategyPattern.With.Strategy;

public class NormalVehicleStrategy implements VehicleStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Vehicle");
    }
}
