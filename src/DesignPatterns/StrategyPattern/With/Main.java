package DesignPatterns.StrategyPattern.With;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new NormalVehicle();
        Vehicle vehicle1 = new SpecialVehicle();

        vehicle1.drive();
        vehicle.drive();
    }
}
