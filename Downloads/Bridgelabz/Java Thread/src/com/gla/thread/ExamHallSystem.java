package com.gla.thread;
class ExamActivity implements Runnable {

    private String activityName;
    private int startDelay;   // when activity starts (ms)
    private int duration;     // how long it runs (ms)

    public ExamActivity(String name, int startDelay, int duration) {
        this.activityName = name;
        this.startDelay = startDelay;
        this.duration = duration;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        try {
            // Initial waiting before starting activity
            Thread.sleep(startDelay);

            System.out.println(activityName + " started | Thread: " + t.getName() +
                    " | State: " + t.getState());

            // Simulate activity work
            for (int i = 1; i <= 3; i++) {
                System.out.println(activityName + " running (Step " + i + ")" +
                        " | Thread: " + t.getName());

                Thread.sleep(duration);
            }

            System.out.println(activityName + " completed | Thread: " + t.getName());

        } catch (InterruptedException e) {
            System.out.println(activityName + " interrupted");
        }
    }
}

public class ExamHallSystem {
    public static void main(String[] args) {

        // Define activities
        ExamActivity entry = new ExamActivity("Student Entry Monitoring", 0, 2000);
        ExamActivity questionPaper = new ExamActivity("Question Paper Distribution", 5000, 2000);
        ExamActivity attendance = new ExamActivity("Attendance Marking", 10000, 2000);
        ExamActivity collection = new ExamActivity("Answer Sheet Collection", 15000, 2000);

        // Create threads
        Thread t1 = new Thread(entry, "Entry-Thread");
        Thread t2 = new Thread(questionPaper, "QuestionPaper-Thread");
        Thread t3 = new Thread(attendance, "Attendance-Thread");
        Thread t4 = new Thread(collection, "Collection-Thread");

        // Set priorities
        t2.setPriority(10); // Question Paper
        t3.setPriority(8);  // Attendance
        t4.setPriority(7);  // Collection
        t1.setPriority(5);  // Entry

        // Display initial states (NEW)
        System.out.println("Initial Thread States:");
        System.out.println(t1.getName() + " -> " + t1.getState());
        System.out.println(t2.getName() + " -> " + t2.getState());
        System.out.println(t3.getName() + " -> " + t3.getState());
        System.out.println(t4.getName() + " -> " + t4.getState());

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Monitor thread states during execution
        try {
            while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()) {

                System.out.println("\n--- Current Thread States ---");
                System.out.println(t1.getName() + " -> " + t1.getState());
                System.out.println(t2.getName() + " -> " + t2.getState());
                System.out.println(t3.getName() + " -> " + t3.getState());
                System.out.println(t4.getName() + " -> " + t4.getState());

                Thread.sleep(3000);
            }

            // Wait for completion
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nAll exam activities completed successfully.");
    }
}

