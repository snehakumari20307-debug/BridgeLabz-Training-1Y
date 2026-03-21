package com.gla.singleinheritance;
class Device {
    protected String deviceId;
    protected boolean status; // true = ON, false = OFF

    // Constructor
    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display general device status
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

// Thermostat subclass
class Thermostat extends Device {
    private double temperatureSetting; // in Celsius

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus(); // display general device info
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Demo class
public class SmartHomeDemo {
    public static void main(String[] args) {
        Device genericDevice = new Device("DEV001", true);
        Thermostat thermostat = new Thermostat("THERMO01", true, 22.5);

        // Display device statuses
        System.out.println("Generic Device:");
        genericDevice.displayStatus();
        System.out.println("-------------------");

        System.out.println("Thermostat:");
        thermostat.displayStatus();
    }
}

