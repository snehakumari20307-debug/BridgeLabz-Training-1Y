package com.gla.markerinterface;
class CloningPrototypeObjects {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee("Anita", 101);
        Employee emp2 = (Employee) emp1.clone(); // clone the object

        System.out.println("Original: " + emp1);
        System.out.println("Cloned: " + emp2);
    }
}

// Class marked Cloneable
class Employee implements Cloneable {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}

