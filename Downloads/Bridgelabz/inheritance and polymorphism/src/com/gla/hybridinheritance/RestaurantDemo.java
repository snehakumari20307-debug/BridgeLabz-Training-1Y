package com.gla.hybridinheritance;
interface Worker {
    void performDuties(); // Interface method for duties
}

// Superclass Person
class Person {
    protected String name;
    protected int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display general info
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

// Chef subclass
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking dishes specializing in " + specialty);
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Chef");
        performDuties();
    }
}

// Waiter subclass
class Waiter extends Person implements Worker {
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables");
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Waiter");
        performDuties();
    }
}

// Demo class
public class RestaurantDemo {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Alice", 102, 5);

        // Display roles and duties
        chef.displayRole();
        System.out.println("-------------------------");
        waiter.displayRole();
    }
}

