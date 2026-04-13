package com.gla.generics;
// Base class
class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Fruit: " + name);
    }
}

// Subclass Apple
class Apple extends Fruit {
    public Apple(String name) {
        super(name);
    }
}

// Subclass Mango
class Mango extends Fruit {
    public Mango(String name) {
        super(name);
    }
}

// A non-fruit class
class Car {
    String model;

    public Car(String model) {
        this.model = model;
    }
}

// Generic FruitBox with bounded type
class FruitBox<T extends Fruit> {
    private T fruit;

    // Add fruit
    public void add(T fruit) {
        this.fruit = fruit;
    }

    // Display fruit
    public void display() {
        if (fruit != null) {
            fruit.display();
        } else {
            System.out.println("Box is empty");
        }
    }
}

// Main class to test
public class FruitStorage{
    public static void main(String[] args) {

        // Apple box
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple("Red Apple"));
        appleBox.display();

        // Mango box
        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.add(new Mango("Alphonso Mango"));
        mangoBox.display();

    }
}
