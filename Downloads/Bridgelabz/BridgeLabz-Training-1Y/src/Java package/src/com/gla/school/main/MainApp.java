package com.gla.school.main;



import com.gla.school.data.*;   // Required import
import com.gla.school.util.*;   // Required import

    public class MainApp {
        public static void main(String[] args) {

            Studentt s1 = new Studentt("Amit", 85, 78, 92);

            Analyzer analyzer = new Analyzer();

            double avg = analyzer.calculateAverage(s1);
            String grade = analyzer.findGrade(avg);

            // Display output
            System.out.println(s1); // Calls toString()
            System.out.println("Average: " + avg);
            System.out.println("Grade: " + grade);
        }
    }

