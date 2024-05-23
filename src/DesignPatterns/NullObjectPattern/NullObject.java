package DesignPatterns.NullObjectPattern;

public class NullObject implements VehicleInterface{
    @Override
    public int getNumberOfSeats() {
        return 0;
    }

    @Override
    public int getFuelCapacity() {
        return 0;
    }
}
