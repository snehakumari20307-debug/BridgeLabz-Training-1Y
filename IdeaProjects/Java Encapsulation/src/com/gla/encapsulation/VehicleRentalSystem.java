package com.gla.encapsulation;

// Interface
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {
    // Encapsulation (private fields)
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Sensitive data (encapsulated)
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Getters & Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) { // restricted setter
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Restricted access (no direct getter for full policy)
    protected String getMaskedPolicyNumber() {
        return "XXXX-" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // Abstract method
    abstract double calculateRentalCost(int days);

    // Display
    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rate per day: " + rentalRate);
    }
}

// Car Class
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days; // fixed per day insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (₹200/day), Policy: " + getMaskedPolicyNumber();
    }
}

// Bike Class
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 50 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (₹50/day), Policy: " + getMaskedPolicyNumber();
    }
}

// Truck Class
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        double base = getRentalRate() * days;
        return base + 1000; // extra load charge
    }

    @Override
    public double calculateInsurance(int days) {
        return 500 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (₹500/day), Policy: " + getMaskedPolicyNumber();
    }
}

// Utility class for polymorphism demo
class RentalProcessor {

    public static void processVehicles(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            v.displayDetails();

            double rentalCost = v.calculateRentalCost(days);

            double insuranceCost = 0;
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insuranceCost = ins.calculateInsurance(days);
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("Rental Cost (" + days + " days): ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insuranceCost);
            System.out.println("Total Cost: ₹" + (rentalCost + insuranceCost));
            System.out.println("-------------------------------");
        }
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {

        // Polymorphism
        Vehicle v1 = new Car("UP32AB1234", 1500, "CAR12345678");
        Vehicle v2 = new Bike("UP32XY5678", 500, "BIKE87654321");
        Vehicle v3 = new Truck("UP32TR9999", 3000, "TRUCK11223344");

        Vehicle[] vehicles = {v1, v2, v3};

        RentalProcessor.processVehicles(vehicles, 3); // 3 days rental
    }
}
