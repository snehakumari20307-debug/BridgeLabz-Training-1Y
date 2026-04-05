package com.gla.wrapperclasses;


    import java.util.ArrayList;
import java.util.Collections;

    public class EmployeeDataProcessing {

        public static void main(String[] args) {

            // Primitive int array (employee ages)
            int[] agesArray = {25, 32, 19, 45, 28, 34};

            // Convert int[] to ArrayList<Integer> using wrapper class
            ArrayList<Integer> ageList = new ArrayList<>();

            for (int age : agesArray) {
                // Autoboxing: int -> Integer
                ageList.add(age);
            }

            // Find youngest and oldest ages
            Integer youngest = Collections.min(ageList);
            Integer oldest = Collections.max(ageList);

            // Display results
            System.out.println("Employee Ages: " + ageList);
            System.out.println("Youngest Age: " + youngest);
            System.out.println("Oldest Age: " + oldest);
        }
    }

