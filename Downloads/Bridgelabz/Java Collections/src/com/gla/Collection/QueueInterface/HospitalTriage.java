package com.gla.Collection.QueueInterface;
import java.util.*;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (" + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        // Max heap based on severity (higher severity first)
        PriorityQueue<Patient> pq = new PriorityQueue<>(
                (a, b) -> b.severity - a.severity
        );

        // Add patients
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.print("Treatment Order: ");

        // Process patients by priority
        while (!pq.isEmpty()) {
            System.out.print(pq.poll().name + " ");
        }
    }
}

