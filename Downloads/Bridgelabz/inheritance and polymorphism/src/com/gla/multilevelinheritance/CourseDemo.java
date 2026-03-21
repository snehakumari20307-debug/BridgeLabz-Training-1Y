package com.gla.multilevelinheritance;
class Course {
    protected String courseName;
    protected int duration; // in hours

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display basic course info
    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass for online courses
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass for paid online courses
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: $" + calculateFinalFee());
    }
}

// Demo class
public class CourseDemo {
    public static void main(String[] args) {
        Course basicCourse = new Course("Introduction to Java", 20);
        OnlineCourse onlineCourse = new OnlineCourse("Data Structures", 30, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Java", 40, "Coursera", false, 200, 15);

        // Polymorphic array of Courses
        Course[] courses = {basicCourse, onlineCourse, paidCourse};

        for (Course c : courses) {
            c.displayCourseInfo();
            System.out.println("----------------------------");
        }
    }
}

