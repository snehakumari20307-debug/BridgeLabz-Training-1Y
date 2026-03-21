package com.gla.functional;

import java.util.function.Predicate;




    public class TemperatureAlertSystem{

        public static void main(String[] args) {
            double currentTemperature = 45.0;
            double threshold = 40.0;

            // Predicate to check temperature
            Predicate<Double> isHighTemp = temp -> temp > threshold;

            if (isHighTemp.test(currentTemperature)) {
                System.out.println("Alert! Temperature crossed the threshold: " + currentTemperature + "°C");
            } else {
                System.out.println("Temperature is normal: " + currentTemperature + "°C");
            }
        }
    }

