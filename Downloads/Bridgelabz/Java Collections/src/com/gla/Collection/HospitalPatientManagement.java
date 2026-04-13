package com.gla.Collection;
import java.util.*;

// Patient class
class Patient {
    String patientId;
    String name;
    int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return patientId + " | " + name + " | Age: " + age;
    }

    // For Set uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient p = (Patient) o;
        return patientId.equals(p.patientId);
    }

    @Override
    public int hashCode() {
        return patientId.hashCode();
    }
}

public class HospitalPatientManagement {

    // 1. Admitted patients (no duplicates)
    private Set<Patient> admittedPatients = new HashSet<>();

    // 2. Waiting queue (FIFO)
    private Queue<Patient> treatmentQueue = new LinkedList<>();

    // 3. Recently discharged (LIFO)
    private Stack<Patient> dischargedStack = new Stack<>();

    // 4. Full history
    private List<Patient> patientHistory = new ArrayList<>();

    // Admit patient
    public void admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            treatmentQueue.offer(p);
            patientHistory.add(p);
            System.out.println("Admitted: " + p);
        } else {
            System.out.println("Duplicate Patient (already admitted): " + p.patientId);
        }
    }

    // Treat patient
    public void treatPatient() {
        if (treatmentQueue.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }

        Patient p = treatmentQueue.poll();
        System.out.println("Treating Patient: " + p);
    }

    // Discharge patient
    public void dischargePatient(Patient p) {
        if (admittedPatients.remove(p)) {
            dischargedStack.push(p);
            System.out.println("Discharged: " + p);
        } else {
            System.out.println("Patient not found in admitted list.");
        }
    }

    // Re-admit last discharged patient
    public void readmitLastPatient() {
        if (dischargedStack.isEmpty()) {
            System.out.println("No recently discharged patients.");
            return;
        }

        Patient p = dischargedStack.pop();
        admittedPatients.add(p);
        treatmentQueue.offer(p);

        System.out.println("Re-admitted: " + p);
    }

    // Show history
    public void showHistory() {
        System.out.println("\n--- Patient History ---");
        for (Patient p : patientHistory) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        HospitalPatientManagement hospital = new HospitalPatientManagement ();

        // Admit patients
        Patient p1 = new Patient("P1", "Amit", 30);
        Patient p2 = new Patient("P2", "Riya", 25);
        Patient p3 = new Patient("P3", "Rahul", 40);

        hospital.admitPatient(p1);
        hospital.admitPatient(p2);
        hospital.admitPatient(p3);
        hospital.admitPatient(p1); // duplicate

        // Treat patients
        hospital.treatPatient();
        hospital.treatPatient();

        // Discharge patient
        hospital.dischargePatient(p1);

        // Re-admit last discharged
        hospital.readmitLastPatient();

        // Show history
        hospital.showHistory();
    }
}

