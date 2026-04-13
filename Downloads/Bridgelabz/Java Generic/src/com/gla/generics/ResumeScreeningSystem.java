package com.gla.generics;
import java.util.*;

public class ResumeScreeningSystem{

    // ---------------- Abstract Job Role ----------------
    static abstract class JobRole {
        String candidateName;
        int experience;

        public JobRole(String candidateName, int experience) {
            this.candidateName = candidateName;
            this.experience = experience;
        }

        public abstract void evaluate();
    }

    // ---------------- Software Engineer ----------------
    static class SoftwareEngineer extends JobRole {
        public SoftwareEngineer(String name, int exp) {
            super(name, exp);
        }

        public void evaluate() {
            System.out.println("Software Engineer: " + candidateName +
                    " | Experience: " + experience + " years");
        }
    }

    // ---------------- Data Scientist ----------------
    static class DataScientist extends JobRole {
        public DataScientist(String name, int exp) {
            super(name, exp);
        }

        public void evaluate() {
            System.out.println("Data Scientist: " + candidateName +
                    " | Experience: " + experience + " years");
        }
    }

    // ---------------- Product Manager ----------------
    static class ProductManager extends JobRole {
        public ProductManager(String name, int exp) {
            super(name, exp);
        }

        public void evaluate() {
            System.out.println("Product Manager: " + candidateName +
                    " | Experience: " + experience + " years");
        }
    }

    // ---------------- Generic Resume Class ----------------
    static class Resume<T extends JobRole> {
        T candidate;

        public Resume(T candidate) {
            this.candidate = candidate;
        }

        public void processResume() {
            candidate.evaluate();
        }
    }

    // ---------------- Generic Screening Method (Wildcard) ----------------
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole r : resumes) {
            r.evaluate();
        }
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        // Create candidates
        SoftwareEngineer se1 = new SoftwareEngineer("Amit", 5);
        DataScientist ds1 = new DataScientist("Neha", 4);
        ProductManager pm1 = new ProductManager("Rahul", 6);

        // Generic Resume objects
        Resume<SoftwareEngineer> r1 = new Resume<>(se1);
        Resume<DataScientist> r2 = new Resume<>(ds1);
        Resume<ProductManager> r3 = new Resume<>(pm1);

        System.out.println("📄 Individual Resume Processing:");
        r1.processResume();
        r2.processResume();
        r3.processResume();

        // Create mixed list for screening pipeline
        List<JobRole> pipeline = new ArrayList<>();
        pipeline.add(se1);
        pipeline.add(ds1);
        pipeline.add(pm1);

        System.out.println("\n🤖 AI Screening Pipeline:");
        screenResumes(pipeline);
    }
}

