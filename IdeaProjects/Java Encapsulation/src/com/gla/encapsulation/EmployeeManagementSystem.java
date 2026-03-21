package com.gla.encapsulation;

// Interface
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract Class
abstract class Employee implements Department {
    // Encapsulation (private fields)
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Department interface methods
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }

    // Abstract method
    abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("---------------------------");
    }
}

// FullTimeEmployee Class
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }
}

// PartTimeEmployee Class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0); // baseSalary not used
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {

        // Polymorphism (Employee reference)
        Employee emp1 = new FullTimeEmployee(101, "Rahul", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Anita", 500, 40);

        emp1.assignDepartment("IT");
        emp2.assignDepartment("HR");

        // Array of Employees (Polymorphism)
        Employee[] employees = {emp1, emp2};

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
