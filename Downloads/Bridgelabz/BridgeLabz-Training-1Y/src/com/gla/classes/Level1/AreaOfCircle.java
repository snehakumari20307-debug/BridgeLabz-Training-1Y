package com.gla.classes.Level1;



    class AreaOfCircle {
        // Attribute for the radius of the circle
        double radius;

        // Constructor to initialize the circle's radius
        public AreaOfCircle(double radius) {
            this.radius = radius;
        }

        // Method to calculate the area of the circle
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        // Method to calculate the circumference of the circle
        public double calculateCircumference() {
            return 2 * Math.PI * radius;
        }

        // Method to display area and circumference
        public void display() {
            System.out.println("Circle Details:");
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + calculateArea());
            System.out.println("Circumference: " + calculateCircumference());
        }

        // Main method to test the Circle class
        public static void main(String[] args) {
            // Create a Circle object
            AreaOfCircle c1 = new AreaOfCircle(5.0);

            // Display the circle's area and circumference
            c1.display();
        }
    }

