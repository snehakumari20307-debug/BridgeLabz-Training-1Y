package com.gla.inheritance;
class Animal {
    protected String name;
    protected int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    // Method to display basic info
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Dog subclass
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Cat subclass
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Bird subclass
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
}

// Demo class to show polymorphism
public class AnimalDemo {
    public static void main(String[] args) {
        // Creating objects
        Animal dog = new Dog("Rex", 5);
        Animal cat = new Cat("Mittens", 3);
        Animal bird = new Bird("Tweety", 1);

        // Polymorphic behavior
        Animal[] animals = {dog, cat, bird};

        for (Animal animal : animals) {
            animal.displayInfo();
            animal.makeSound();  // overridden method called based on object type
            System.out.println("------------------");
        }
    }
}

