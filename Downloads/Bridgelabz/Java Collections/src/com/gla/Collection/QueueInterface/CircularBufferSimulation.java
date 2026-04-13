package com.gla.Collection.QueueInterface;
import java.util.Arrays;

class CircularBuffer {
    int[] arr;
    int size;
    int front;
    int rear;
    int count;

    CircularBuffer(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert element (overwrite if full)
    public void insert(int value) {

        // If full, move front (overwrite oldest)
        if (count == size) {
            front = (front + 1) % size;
            count--;
        }

        // Move rear circularly
        rear = (rear + 1) % size;
        arr[rear] = value;
        count++;
    }

    // Display buffer
    public void display() {
        System.out.print("Buffer: [");

        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print(arr[index]);
            if (i < count - 1) System.out.print(", ");
        }

        System.out.println("]");
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {

        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        buffer.display(); // [1, 2, 3]

        buffer.insert(4); // overwrites 1

        buffer.display(); // [2, 3, 4]
    }
}

