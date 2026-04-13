package com.gla.generics;

import java.util.*;

public class PersonalizedMealPlan{

    // ---------------- MealPlan Interface ----------------
    interface MealPlan {
        void showPlan();
    }

    // ---------------- Meal Types ----------------
    static class VegetarianMeal implements MealPlan {
        String name;

        public VegetarianMeal(String name) {
            this.name = name;
        }

        public void showPlan() {
            System.out.println("Vegetarian Meal: " + name);
        }
    }

    static class VeganMeal implements MealPlan {
        String name;

        public VeganMeal(String name) {
            this.name = name;
        }

        public void showPlan() {
            System.out.println("Vegan Meal: " + name);
        }
    }

    static class KetoMeal implements MealPlan {
        String name;

        public KetoMeal(String name) {
            this.name = name;
        }

        public void showPlan() {
            System.out.println("Keto Meal: " + name);
        }
    }

    static class HighProteinMeal implements MealPlan {
        String name;

        public HighProteinMeal(String name) {
            this.name = name;
        }

        public void showPlan() {
            System.out.println("High-Protein Meal: " + name);
        }
    }

    // ---------------- Generic Meal Class ----------------
    static class Meal<T extends MealPlan> {
        T meal;

        public Meal(T meal) {
            this.meal = meal;
        }

        public void displayMeal() {
            meal.showPlan();
        }
    }

    // ---------------- Generic Validation Method ----------------
    public static <T extends MealPlan> Meal<T> generateMeal(T meal) {

        // Validation logic (can be expanded)
        if (meal == null) {
            System.out.println("Invalid meal plan!");
            return null;
        }

        return new Meal<>(meal);
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        // Create meal plans
        VegetarianMeal veg = new VegetarianMeal("Paneer Curry + Rice");
        VeganMeal vegan = new VeganMeal("Tofu Salad + Smoothie");
        KetoMeal keto = new KetoMeal("Eggs + Avocado + Chicken");
        HighProteinMeal protein = new HighProteinMeal("Chicken Breast + Eggs");

        // Generate meals using generic method
        Meal<VegetarianMeal> m1 = generateMeal(veg);
        Meal<VeganMeal> m2 = generateMeal(vegan);
        Meal<KetoMeal> m3 = generateMeal(keto);
        Meal<HighProteinMeal> m4 = generateMeal(protein);

        // Display meals
        System.out.println("🍽️ Personalized Meal Plans:");
        m1.displayMeal();
        m2.displayMeal();
        m3.displayMeal();
        m4.displayMeal();
    }
}
