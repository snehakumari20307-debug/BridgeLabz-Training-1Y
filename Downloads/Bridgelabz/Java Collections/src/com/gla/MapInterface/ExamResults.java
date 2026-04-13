package com.gla.MapInterface;
import java.util.*;

public class ExamResults {

    // Subject -> (Student -> Marks)
    private Map<String, Map<String, Integer>> examData = new HashMap<>();

    // 1. Add marks
    public void addMarks(String subject, String student, int marks) {
        examData.putIfAbsent(subject, new HashMap<>());
        examData.get(subject).put(student, marks);
    }

    // 2. Top scorer per subject
    public void printTopScorers() {

        System.out.println("\n--- Top Scorers per Subject ---");

        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examData.entrySet()) {

            String subject = subjectEntry.getKey();
            Map<String, Integer> students = subjectEntry.getValue();

            String topStudent = null;
            int maxMarks = -1;

            for (Map.Entry<String, Integer> entry : students.entrySet()) {
                if (entry.getValue() > maxMarks) {
                    maxMarks = entry.getValue();
                    topStudent = entry.getKey();
                }
            }

            System.out.println(subject + " -> " + topStudent + " (" + maxMarks + ")");
        }
    }

    // 3. Average score per subject
    public void printAverageScores() {

        System.out.println("\n--- Average Score per Subject ---");

        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examData.entrySet()) {

            String subject = subjectEntry.getKey();
            Map<String, Integer> students = subjectEntry.getValue();

            int sum = 0;
            int count = students.size();

            for (int marks : students.values()) {
                sum += marks;
            }

            double avg = (count == 0) ? 0 : (double) sum / count;

            System.out.println(subject + " -> Average: " + avg);
        }
    }

    // 4. Subjects with at least one score > 90
    public void printHighScoringSubjects() {

        System.out.println("\n--- Subjects with Score > 90 ---");

        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examData.entrySet()) {

            String subject = subjectEntry.getKey();
            Map<String, Integer> students = subjectEntry.getValue();

            boolean found = false;

            for (int marks : students.values()) {
                if (marks > 90) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(subject);
            }
        }
    }

    public static void main(String[] args) {

        ExamResults system = new ExamResults();

        // 1. Add data
        system.addMarks("Math", "Amit", 95);
        system.addMarks("Math", "Riya", 88);
        system.addMarks("Math", "Rahul", 76);

        system.addMarks("Science", "Amit", 85);
        system.addMarks("Science", "Riya", 91);
        system.addMarks("Science", "Rahul", 89);

        system.addMarks("English", "Amit", 78);
        system.addMarks("English", "Riya", 92);
        system.addMarks("English", "Rahul", 84);

        // 2. Top scorers
        system.printTopScorers();

        // 3. Average scores
        system.printAverageScores();

        // 4. High scoring subjects
        system.printHighScoringSubjects();
    }
}

