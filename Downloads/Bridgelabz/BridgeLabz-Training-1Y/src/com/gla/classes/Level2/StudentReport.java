package com.gla.classes.Level2;
// Student.java
class StudentReport {
    // Attributes
    String name;
    int rollNumber;
    double marks;

    // Constructor to initialize student details
    public StudentReport(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on marks
    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display student details and grade
    public void displayDetails() {
        System.out.println("Student Report:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("---------------------------");
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        // Creating student objects
        StudentReport s1 = new StudentReport("Alice", 101, 92.5);
        StudentReport s2 = new StudentReport("Bob", 102, 76.0);
        StudentReport s3 = new StudentReport("Charlie", 103, 58.5);

        // Displaying student reports
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
    }
}
