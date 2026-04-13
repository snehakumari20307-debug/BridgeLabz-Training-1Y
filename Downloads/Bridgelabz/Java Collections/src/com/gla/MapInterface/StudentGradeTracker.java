package com.gla.MapInterface;
import java.util.*;

public class StudentGradeTracker {

    // Map to store student name and grade
    private Map<String, Double> grades = new HashMap<>();

    // 1. Add student
    public void addStudent(String name, double grade) {
        grades.put(name, grade);
        System.out.println("Added: " + name + " -> " + grade);
    }

    // 2. Update grade
    public void updateGrade(String name, double newGrade) {
        if (grades.containsKey(name)) {
            grades.put(name, newGrade);
            System.out.println("Updated: " + name + " -> " + newGrade);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    // 3. Remove student
    public void removeStudent(String name) {
        if (grades.remove(name) != null) {
            System.out.println("Removed: " + name);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    // 4. Print sorted by name (alphabetical order)
    public void printSortedGrades() {
        System.out.println("\n--- Student Grades (Alphabetical Order) ---");

        // TreeMap automatically sorts by key
        Map<String, Double> sorted = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();

        // 1. Add students
        tracker.addStudent("Amit", 85.5);
        tracker.addStudent("Riya", 92.0);
        tracker.addStudent("Rahul", 78.0);
        tracker.addStudent("Sneha", 88.5);

        // 2. Update grade (re-test)
        tracker.updateGrade("Rahul", 82.0);

        // 3. Remove student
        tracker.removeStudent("Sneha");

        // 4. Print sorted list
        tracker.printSortedGrades();
    }
}

