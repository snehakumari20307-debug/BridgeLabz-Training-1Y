package com.gla.generics;
import java.util.*;

// Base class
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println(name + " makes a sound");
    }
}

// Dog class
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " barks");
    }
}

// Cat class
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " meows");
    }
}

public class AnimalHierarchy {

    // Method using wildcard
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

    public static void main(String[] args) {

        // List of Dogs
        List<Dog> dogs = Arrays.asList(
                new Dog("Buddy"),
                new Dog("Tommy")
        );

        // List of Cats
        List<Cat> cats = Arrays.asList(
                new Cat("Kitty"),
                new Cat("Luna")
        );

        // Works for both
        printAnimals(dogs);
        printAnimals(cats);
    }
}

