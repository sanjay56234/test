package DesignPatterns.StrategyPattern.Without;

public class Main {
    public static void main(String[] args) {

        Vehicle sports = new SportsVehicle();
        Vehicle offroad = new OffroadVehicle();
        Vehicle pasenger = new Passenger();
        sports.drive();
        offroad.drive();
        pasenger.drive();

    }
}
