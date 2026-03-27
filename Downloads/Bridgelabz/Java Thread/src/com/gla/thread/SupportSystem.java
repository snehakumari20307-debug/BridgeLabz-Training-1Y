package com.gla.thread;
import java.util.*;

class Ticket extends Thread {

    private static int counter = 1;
    private static long totalProcessingTime = 0;

    private static Map<Integer, List<Long>> waitTimeMap = new HashMap<>();

    private int ticketId;
    private String type;
    private int priority;
    private int queuePosition;

    public Ticket(String type, int priority, int queuePosition) {
        this.ticketId = counter++;
        this.type = type;
        this.priority = priority;
        this.queuePosition = queuePosition;

        setName("Agent-" + ticketId);
        setPriority(priority);

        waitTimeMap.putIfAbsent(priority, new ArrayList<>());
    }

    @Override
    public void run() {
        try {
            long startWait = System.currentTimeMillis();

            System.out.println("Ticket #" + ticketId +
                    " | Type: " + type +
                    " | Priority: " + priority +
                    " | Queue Position: " + queuePosition +
                    " | Assigned to: " + getName());

            System.out.println("➡ Processing STARTED for Ticket #" + ticketId);

            // Random processing time (1–5 seconds)
            int processTime = new Random().nextInt(5) + 1;
            Thread.sleep(processTime * 1000);

            long endTime = System.currentTimeMillis();
            long totalTime = (endTime - startWait) / 1000;

            synchronized (Ticket.class) {
                totalProcessingTime += totalTime;
                waitTimeMap.get(priority).add(totalTime);
            }

            System.out.println("✅ Processing COMPLETED for Ticket #" + ticketId +
                    " | Time Taken: " + totalTime + " sec\n");

        } catch (InterruptedException e) {
            System.out.println("Ticket #" + ticketId + " interrupted");
        }
    }

    public static void printStatistics() {
        System.out.println("\n===== STATISTICS =====");

        for (Map.Entry<Integer, List<Long>> entry : waitTimeMap.entrySet()) {
            int priority = entry.getKey();
            List<Long> times = entry.getValue();

            double avg = times.stream().mapToLong(Long::longValue).average().orElse(0);

            System.out.println("Priority " + priority +
                    " → Average Processing Time: " + String.format("%.2f", avg) + " sec");
        }

        System.out.println("Total Processing Time: " + totalProcessingTime + " sec");
    }
}

public class SupportSystem {
    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>();

        // Create 10 mixed tickets
        tickets.add(new Ticket("Critical Bug", 10, 1));
        tickets.add(new Ticket("Feature Request", 4, 2));
        tickets.add(new Ticket("General Query", 2, 3));
        tickets.add(new Ticket("Feedback", 1, 4));
        tickets.add(new Ticket("Critical Bug", 10, 5));
        tickets.add(new Ticket("General Query", 2, 6));
        tickets.add(new Ticket("Feature Request", 4, 7));
        tickets.add(new Ticket("Feedback", 1, 8));
        tickets.add(new Ticket("Critical Bug", 10, 9));
        tickets.add(new Ticket("General Query", 2, 10));

        // Sort tickets by priority (highest first)
        tickets.sort((t1, t2) -> t2.getPriority() - t1.getPriority());

        System.out.println("=== Ticket Processing Order (By Priority) ===");
        for (Ticket t : tickets) {
            System.out.println("Ticket #" + t.getId() + " | Priority: " + t.getPriority());
        }

        // Start threads
        for (Ticket t : tickets) {
            t.start();
        }

        // Wait for all to finish
        for (Ticket t : tickets) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrupted");
            }
        }

        // Print statistics
        Ticket.printStatistics();
    }
}

