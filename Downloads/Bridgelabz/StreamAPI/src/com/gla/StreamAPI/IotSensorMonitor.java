package com.gla.StreamAPI;
import java.util.*;

record SensorReading(String sensorId, double value, String unit) {}

public class IotSensorMonitor {
    public static void main(String[] args) {
        List<SensorReading> readings = Arrays.asList(
                new SensorReading("TEMP-01", 22.5, "Celsius"),
                new SensorReading("TEMP-02", 82.1, "Celsius"), // Alert
                new SensorReading("TEMP-03", 19.8, "Celsius"),
                new SensorReading("TEMP-04", 76.5, "Celsius"), // Alert
                new SensorReading("TEMP-05", 21.2, "Celsius")
        );

        double threshold = 75.0;

        System.out.println("--- CRITICAL THRESHOLD ALERTS ---");

        // 1. Convert to Stream
        // 2. Filter for values above threshold
        // 3. Use forEach to trigger action (printing/logging)
        readings.stream()
                .filter(r -> r.value() > threshold)
                .forEach(r -> System.out.printf("ALERT: Sensor %s reported dangerous level: %.1f %s%n",
                        r.sensorId(), r.value(), r.unit()));
    }
}

