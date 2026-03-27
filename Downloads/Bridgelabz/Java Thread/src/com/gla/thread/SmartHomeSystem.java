package com.gla.thread;
import java.time.LocalTime;

// Base class using Runnable
class Device implements Runnable {

    private String deviceName;
    private int interval;

    public Device(String deviceName, int interval) {
        this.deviceName = deviceName;
        this.interval = interval;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    "[" + LocalTime.now() + "] " +
                            deviceName + " running (Cycle " + i + ")" +
                            " | Thread: " + t.getName() +
                            " | Priority: " + t.getPriority()
            );

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println(deviceName + " interrupted");
            }
        }

        System.out.println(deviceName + " finished execution.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {

        // Create devices
        Device temperature = new Device("Temperature Sensor", 5000);
        Device security = new Device("Security Camera", 3000);
        Device light = new Device("Light Controller", 4000);
        Device door = new Device("Door Lock Monitor", 6000);

        // Create threads
        Thread t1 = new Thread(security, "Security-Thread");
        Thread t2 = new Thread(temperature, "Temperature-Thread");
        Thread t3 = new Thread(light, "Light-Thread");
        Thread t4 = new Thread(door, "Door-Thread");

        // Set priorities
        t1.setPriority(10); // Security
        t2.setPriority(7);  // Temperature
        t3.setPriority(5);  // Light
        t4.setPriority(5);  // Door

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nAll smart home devices have completed their cycles.");
    }
}

