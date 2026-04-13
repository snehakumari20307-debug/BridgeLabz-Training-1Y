package com.gla.generics;

import java.util.*;

class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Vehicle: " + name);
    }
}


class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("Truck: " + name);
    }
}


class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("Bike: " + name);
    }
}
public class GenericFleetManager{

    static class FleetManager<T extends Vehicle> {
        private List<T> fleet = new ArrayList<>();


        public void addVehicle(T vehicle) {
            fleet.add(vehicle);
        }


        public void showFleet() {
            if (fleet.isEmpty()) {
                System.out.println("Fleet is empty");
                return;
            }

            for (T vehicle : fleet) {
                vehicle.show();
            }
        }
    }

    public static void main(String[] args) {


        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.addVehicle(new Truck("Ashok Leyland"));

        System.out.println("🚛 Truck Fleet:");
        truckFleet.showFleet();

        System.out.println();

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Royal Enfield"));
        bikeFleet.addVehicle(new Bike("Yamaha R15"));

        System.out.println("🏍 Bike Fleet:");
        bikeFleet.showFleet();


    }
}
