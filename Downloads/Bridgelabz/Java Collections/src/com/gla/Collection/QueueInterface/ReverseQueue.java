package com.gla.Collection.QueueInterface;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    // Function to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {

        // Base case
        if (queue.isEmpty()) {
            return;
        }

        // Remove front element
        int front = queue.remove();

        // Recursive call
        reverseQueue(queue);

        // Add removed element at the rear
        queue.add(front);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // Input: [10, 20, 30]
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

