package com.gla.inheritance;
class Employee {
    protected String name;
    protected int id;
    protected double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: ₹" + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer subclass
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern subclass
class Intern extends Employee {
    private String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

// Demo class to show polymorphism
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 120000, 5);
        Employee developer = new Developer("Bob", 102, 90000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, "MIT");

        // Polymorphic array
        Employee[] employees = {manager, developer, intern};

        for (Employee emp : employees) {
            emp.displayDetails();  // overridden method called
            System.out.println("-------------------");
        }
    }
}
