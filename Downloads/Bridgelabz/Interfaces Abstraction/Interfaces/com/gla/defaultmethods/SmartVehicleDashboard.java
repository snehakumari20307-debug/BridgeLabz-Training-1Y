package com.gla.defaultmethods;
interface VehicleDashboard {
    void displaySpeed();

    // Default method for battery display
    default void displayBattery() {
        System.out.println("Battery status not available for this vehicle.");
    }
}

// GasCar class
class GasCar implements VehicleDashboard {
    @Override
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
}

// ElectricCar class
class ElectricCar implements VehicleDashboard {
    @Override
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }

    @Override
    public void displayBattery() {
        System.out.println("Battery: 85%");
    }
}

// Demo
public class SmartVehicleDashboard {
    public static void main(String[] args) {
        VehicleDashboard gasCar = new GasCar();
        VehicleDashboard electricCar = new ElectricCar();

        gasCar.displaySpeed();
        gasCar.displayBattery(); // uses default

        electricCar.displaySpeed();
        electricCar.displayBattery(); // overridden
    }
}

