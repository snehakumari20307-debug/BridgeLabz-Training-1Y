package com.gla.bank.util;

public class InterestCalculator {


        // Simple Interest
        public double calculateSimpleInterest(double P, double R, double T) {
            return (P * R * T) / 100;
        }

        // Compound Interest (formula applied, pow used in main via static import)
        public double calculateCompoundInterest(double P, double R, double T, double powerValue) {
            return P * powerValue - P;
        }
    }

