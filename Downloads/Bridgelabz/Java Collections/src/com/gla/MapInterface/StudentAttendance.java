package com.gla.MapInterface;
import java.util.*;

public class StudentAttendance {

    public static void main(String[] args) {

        // 1. Initialize students with 0 attendance
        Map<String, Integer> attendance = new HashMap<>();

        String[] students = {"Amit", "Riya", "Rahul", "Sneha", "Neha"};

        for (String s : students) {
            attendance.put(s, 0);
        }

        Random random = new Random();

        // 2. Simulate 15 days of attendance
        for (int day = 1; day <= 15; day++) {

            System.out.println("Day " + day + " attendance:");

            // Randomly decide who is present (simulate 3-5 students present per day)
            Set<String> presentToday = new HashSet<>();

            int presentCount = 3 + random.nextInt(3); // 3 to 5 students

            while (presentToday.size() < presentCount) {
                String student = students[random.nextInt(students.length)];
                presentToday.add(student);
            }

            // Mark attendance
            for (String student : presentToday) {
                attendance.put(student, attendance.get(student) + 1);
            }

            System.out.println("Present: " + presentToday);
            System.out.println();
        }

        // 3. Print final attendance
        System.out.println("\n--- Final Attendance ---");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 4. Under-attending students (< 10 days)
        int threshold = 10;

        System.out.println("\n--- Under-attending Students (less than " + threshold + " days) ---");

        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " days");
            }
        }
    }
}

