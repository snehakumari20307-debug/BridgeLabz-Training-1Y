package com.gla.wrapperclasses;
import java.util.ArrayList;

public class SensorDataLogger {

    // Method to log temperature from Double (wrapper) input
    public static void logTemperature(Double temperature, ArrayList<Double> storage) {
        // Handle null input safely
        if (temperature == null) {
            System.out.println("Received null temperature. Skipping...");
            return;
        }

        // Autoboxing happens here: primitive double -> Double object
        storage.add(temperature);

        System.out.println("Logged temperature: " + temperature);
    }

    // Overloaded method to log temperature from primitive double
    public static void logTemperature(double temperature, ArrayList<Double> storage) {
        // Autoboxing automatically converts double -> Double
        storage.add(temperature);
        System.out.println("Logged temperature: " + temperature);
    }

    public static void main(String[] args) {
        // Storage for sensor data (uses Double objects)
        ArrayList<Double> sensorData = new ArrayList<>();

        // Logging primitive double
        double temp1 = 23.5;
        logTemperature(temp1, sensorData);

        // Logging Double object
        Double temp2 = 27.8;
        logTemperature(temp2, sensorData);

        // Logging null value
        Double temp3 = null;
        logTemperature(temp3, sensorData);

        // Reading stored values (auto-unboxing Double -> double)
        System.out.println("\nReading stored sensor data:");
        for (Double temp : sensorData) {
            double primitiveTemp = temp; // auto-unboxing
            System.out.println("Temperature: " + primitiveTemp);
        }
    }
}

