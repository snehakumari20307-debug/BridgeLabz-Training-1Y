package com.gla.generics;
import java.util.*;

public class ManagementSystem {

    // ---------------- Abstract Base Course Type ----------------
    static abstract class CourseType {
        String courseName;
        int credits;

        public CourseType(String courseName, int credits) {
            this.courseName = courseName;
            this.credits = credits;
        }

        public abstract void display();
    }

    // ---------------- Exam-Based Course ----------------
    static class ExamCourse extends CourseType {
        public ExamCourse(String courseName, int credits) {
            super(courseName, credits);
        }

        @Override
        public void display() {
            System.out.println("Exam Course: " + courseName + " | Credits: " + credits);
        }
    }

    // ---------------- Assignment-Based Course ----------------
    static class AssignmentCourse extends CourseType {
        public AssignmentCourse(String courseName, int credits) {
            super(courseName, credits);
        }

        @Override
        public void display() {
            System.out.println("Assignment Course: " + courseName + " | Credits: " + credits);
        }
    }

    // ---------------- Research-Based Course ----------------
    static class ResearchCourse extends CourseType {
        public ResearchCourse(String courseName, int credits) {
            super(courseName, credits);
        }

        @Override
        public void display() {
            System.out.println("Research Course: " + courseName + " | Credits: " + credits);
        }
    }

    // ---------------- Generic Course Class ----------------
    static class Course<T extends CourseType> {
        private List<T> courses = new ArrayList<>();

        public void addCourse(T course) {
            courses.add(course);
        }

        public List<T> getCourses() {
            return courses;
        }
    }

    // ---------------- Wildcard Method ----------------
    public static void showAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.display();
        }
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        // Exam Courses
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Data Structures", 4));
        examCourses.addCourse(new ExamCourse("Algorithms", 3));

        // Assignment Courses
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Web Development", 3));
        assignmentCourses.addCourse(new AssignmentCourse("Database Systems", 4));

        // Research Courses
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research", 5));
        researchCourses.addCourse(new ResearchCourse("Machine Learning", 5));

        // Display using wildcard method
        System.out.println("🎓 Exam Courses:");
        showAllCourses(examCourses.getCourses());

        System.out.println("\n📝 Assignment Courses:");
        showAllCourses(assignmentCourses.getCourses());

        System.out.println("\n🔬 Research Courses:");
        showAllCourses(researchCourses.getCourses());
    }
}
