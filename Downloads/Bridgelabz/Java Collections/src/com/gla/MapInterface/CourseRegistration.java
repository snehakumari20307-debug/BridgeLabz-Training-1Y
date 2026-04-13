package com.gla.MapInterface;
import java.util.*;

public class CourseRegistration {

    private Map<String, Integer> courseMap = new HashMap<>();

    // 1. Add course with initial count
    public void addCourse(String courseCode, int count) {
        courseMap.put(courseCode, count);
        System.out.println("Added: " + courseCode + " -> " + count + " students");
    }

    // 2. Add student
    public void addStudent(String courseCode) {
        if (!courseMap.containsKey(courseCode)) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        courseMap.put(courseCode, courseMap.get(courseCode) + 1);
        System.out.println("Student added to " + courseCode);
    }

    // 2. Drop student (count should not go negative)
    public void dropStudent(String courseCode) {
        if (!courseMap.containsKey(courseCode)) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        int current = courseMap.get(courseCode);

        if (current > 0) {
            courseMap.put(courseCode, current - 1);
            System.out.println("Student dropped from " + courseCode);
        } else {
            System.out.println("Cannot drop. Already at 0: " + courseCode);
        }
    }

    // 3. Print course status
    public void printStatus() {

        System.out.println("\n--- Course Status ---");

        System.out.println("\n📌 Near Full Courses (≥ 50):");
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\n⚠ Under-subscribed Courses (< 5):");
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Main method (simulation)
    public static void main(String[] args) {

        CourseRegistration system = new CourseRegistration();

        // 1. Add 5 courses
        system.addCourse("CS101", 48);
        system.addCourse("CS102", 3);
        system.addCourse("CS103", 55);
        system.addCourse("CS104", 10);
        system.addCourse("CS105", 0);

        // 2. Simulate add/drop operations
        system.addStudent("CS101");
        system.addStudent("CS102");
        system.addStudent("CS105");

        system.dropStudent("CS104");
        system.dropStudent("CS105");
        system.dropStudent("CS105"); // test edge case

        // 3. Print final status
        system.printStatus();
    }
}

