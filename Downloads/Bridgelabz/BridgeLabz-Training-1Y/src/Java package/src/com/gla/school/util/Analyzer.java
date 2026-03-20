package com.gla.school.util;



import com.gla.school.data.Studentt;

    public class Analyzer {

        // Calculate average
        public double calculateAverage(Studentt s) {
            return (s.getMarks1() + s.getMarks2() + s.getMarks3()) / 3.0;
        }

        // Assign grade
        public String findGrade(double avg) {
            if (avg >= 90) return "A";
            else if (avg >= 75) return "B";
            else if (avg >= 60) return "C";
            else if (avg >= 50) return "D";
            else return "F";
        }
    }

