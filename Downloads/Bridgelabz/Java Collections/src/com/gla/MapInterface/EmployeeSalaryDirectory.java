package com.gla.MapInterface;
import java.util.*;

public class EmployeeSalaryDirectory {

    private Map<String, Double> salaries = new HashMap<>();

    // 1. Add employee
    public void addEmployee(String name, double salary) {
        salaries.put(name, salary);
        System.out.println("Added: " + name + " -> " + salary);
    }

    // 2. Give raise (percentage)
    public void giveRaise(String name, double percent) {
        if (!salaries.containsKey(name)) {
            System.out.println("Employee not found: " + name);
            return;
        }

        double current = salaries.get(name);
        double updated = current + (current * percent / 100.0);

        salaries.put(name, updated);

        System.out.println("Raise given to " + name + " -> " + updated);
    }

    // 3. Average salary
    public void printAverageSalary() {
        if (salaries.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        double sum = 0;

        for (double sal : salaries.values()) {
            sum += sal;
        }

        double avg = sum / salaries.size();

        System.out.println("\nAverage Salary: " + avg);
    }

    // 4. Highest paid employee(s)
    public void printHighestPaid() {
        if (salaries.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        double maxSalary = Collections.max(salaries.values());

        System.out.println("\nHighest Paid Employee(s):");

        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == maxSalary) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Show all employees
    public void showAll() {
        System.out.println("\n--- Employee List ---");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        EmployeeSalaryDirectory company = new EmployeeSalaryDirectory();

        // 1. Add 6 employees
        company.addEmployee("Amit", 50000);
        company.addEmployee("Riya", 60000);
        company.addEmployee("Rahul", 55000);
        company.addEmployee("Sneha", 70000);
        company.addEmployee("Neha", 65000);
        company.addEmployee("Karan", 60000);

        // 2. Give raises
        company.giveRaise("Amit", 10);   // +10%
        company.giveRaise("Riya", 5);    // +5%
        company.giveRaise("Neha", 20);   // +20%
        company.giveRaise("Unknown", 10); // test case

        // 3. Show all employees
        company.showAll();

        // 4. Average salary
        company.printAverageSalary();

        // 5. Highest paid employees
        company.printHighestPaid();
    }
}
