package com.gla.defining;

interface VehicleRental {
    void rent();
    void returnVehicle();
}

// Car class implementing VehicleRental
class Car implements VehicleRental {
    @Override
    public void rent() {
        System.out.println("Car rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned successfully");
    }
}

// Bike class implementing VehicleRental
class Bike implements VehicleRental {
    @Override
    public void rent() {
        System.out.println("Bike rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike returned successfully");
    }
}

// Bus class implementing VehicleRental
class Bus implements VehicleRental {
    @Override
    public void rent() {
        System.out.println("Bus rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned successfully");
    }
}

// Demo
public class MultiVehicleRental {
    public static void main(String[] args) {
        VehicleRental car = new Car();
        VehicleRental bike = new Bike();
        VehicleRental bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
