package com.gla.functional;

public class BackgroundJobExecution {
    public static void main(String[] args) {
        // Runnable task
        Runnable task = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background job completed!");
        };

        // Execute asynchronously
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues...");
    }
}

