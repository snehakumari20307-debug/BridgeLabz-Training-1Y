package com.gla.encapsulation;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    protected String diagnosis;
    protected String medicalHistory = "";

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation: Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Concrete Method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }

    // Abstract Method
    public abstract double calculateBill();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 500; // hospital fee
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for InPatient " + getName() + ":\n" + medicalHistory);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for OutPatient " + getName() + ":\n" + medicalHistory);
    }
}

// Main class to demonstrate polymorphism
public class HospitalPatientSystem {

    public static void displayBill(Patient patient) {
        patient.getPatientDetails();
        double bill = patient.calculateBill();
        System.out.println("Total Bill: ₹" + bill);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        // Creating patients
        Patient inPatient = new InPatient("IP101", "Rahul", 45, 5, 2000);
        Patient outPatient = new OutPatient("OP202", "Anita", 30, 500);

        // Setting diagnoses
        inPatient.setDiagnosis("Appendicitis");
        outPatient.setDiagnosis("Flu");

        // Adding medical records
        ((MedicalRecord) inPatient).addRecord("Appendectomy performed on 2026-03-20");
        ((MedicalRecord) outPatient).addRecord("Prescribed flu medication");

        // Polymorphic billing
        displayBill(inPatient);
        displayBill(outPatient);

        // Viewing medical records
        ((MedicalRecord) inPatient).viewRecords();
        ((MedicalRecord) outPatient).viewRecords();
    }
}
