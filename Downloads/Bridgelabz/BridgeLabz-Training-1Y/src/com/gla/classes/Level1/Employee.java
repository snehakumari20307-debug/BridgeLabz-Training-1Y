package com.gla.classes.Level1;



    class Employee {
        // Attributes of the Employee
        String name;
        int id;
        double salary;

        // Constructor to initialize Employee object
        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        // Method to display employee details
        public void displayDetails() {
            System.out.println("Employee Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Salary: $" + salary);
        }

        // Main method to test the Employee class
        public static void main(String[] args) {
            // Creating an Employee object
            Employee emp1 = new Employee("John Doe", 101, 55000.0);

            // Displaying the employee details
            emp1.displayDetails();
        }
    }

