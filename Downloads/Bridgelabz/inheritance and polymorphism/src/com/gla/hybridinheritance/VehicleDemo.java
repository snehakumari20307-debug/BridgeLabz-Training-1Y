package com.gla.hybridinheritance;
interface Refuelable {
    void refuel(); // Interface method for refueling
}

// Superclass Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed; // in km/h

    // Constructor
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Method to display basic vehicle info
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {
    private int batteryPercentage;

    public ElectricVehicle(String model, int maxSpeed, int batteryPercentage) {
        super(model, maxSpeed);
        this.batteryPercentage = batteryPercentage;
    }

    // Charge method specific to electric vehicles
    public void charge() {
        System.out.println(model + " is charging. Battery at " + batteryPercentage + "%");
    }

    public void displayVehicle() {
        displayInfo();
        System.out.println("Vehicle Type: Electric");
        charge();
    }
}

// PetrolVehicle subclass implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelLevel; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelLevel) {
        super(model, maxSpeed);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel level at " + fuelLevel + " liters");
    }

    public void displayVehicle() {
        displayInfo();
        System.out.println("Vehicle Type: Petrol");
        refuel();
    }
}

// Demo class
public class VehicleDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 80);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        // Display vehicle info
        ev.displayVehicle();
        System.out.println("------------------------");
        pv.displayVehicle();
    }
}

