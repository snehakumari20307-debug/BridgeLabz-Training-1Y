package com.gla.Collection;
import java.util.*;

 class FeedbackSystem {

    // 1. All feedback entries
    private List<String> feedbackList = new ArrayList<>();

    // 2. Unique feedbacks (remove duplicates)
    private Set<String> uniqueFeedbackSet = new LinkedHashSet<>();

    // 3. Processing queue (FIFO)
    private Queue<String> feedbackQueue = new LinkedList<>();

    // 4. Recent feedbacks (LIFO)
    private Stack<String> recentStack = new Stack<>();

    // -------------------------------
    // 1. Add Feedback
    // -------------------------------
    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
        System.out.println("Added: " + feedback);
    }

    // -------------------------------
    // 2. Remove Duplicates & Prepare Processing
    // -------------------------------
    public void prepareFeedbackProcessing() {
        uniqueFeedbackSet.clear();
        feedbackQueue.clear();
        recentStack.clear();

        // Remove duplicates using Set
        for (String fb : feedbackList) {
            uniqueFeedbackSet.add(fb);
        }

        // Add to queue and stack
        for (String fb : uniqueFeedbackSet) {
            feedbackQueue.add(fb);
            recentStack.push(fb);
        }

        System.out.println("\nDuplicates removed. Ready for processing.");
    }

    // -------------------------------
    // 3. Process Feedback Sequentially
    // -------------------------------
    public void processFeedback() {
        System.out.println("\nProcessing Feedback:");

        while (!feedbackQueue.isEmpty()) {
            String fb = feedbackQueue.poll();
            System.out.println("Processed: " + fb);
        }
    }

    // -------------------------------
    // 4. Show Recent Feedbacks
    // -------------------------------
    public void showRecentFeedbacks() {
        System.out.println("\nRecent Feedback (Latest First):");
        for (String fb : recentStack) {
            System.out.println(fb);
        }
    }
}
public class CustomerFeedbackAnalysis {
    public static void main(String[] args) {

        FeedbackSystem system = new FeedbackSystem();

        // Add feedback messages
        system.addFeedback("Great service!");
        system.addFeedback("Good app experience");
        system.addFeedback("Great service!"); // duplicate
        system.addFeedback("Needs improvement");
        system.addFeedback("Good app experience"); // duplicate

        // Remove duplicates & prepare processing
        system.prepareFeedbackProcessing();

        // Process feedback sequentially
        system.processFeedback();

        // Show recent feedbacks
        system.showRecentFeedbacks();
    }
}
