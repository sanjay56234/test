package DesignPatterns.NullObjectPattern;

public class Car implements VehicleInterface{
    @Override
    public int getNumberOfSeats() {
        return 40;
    }

    @Override
    public int getFuelCapacity() {
        return 60;
    }
}
