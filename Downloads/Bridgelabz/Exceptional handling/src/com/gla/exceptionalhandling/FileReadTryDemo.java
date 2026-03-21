package com.gla.exceptionalhandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTryDemo {
    public static void main(String[] args) {
        // File to read
        String filename = "info.txt";

        // Try-with-resources ensures BufferedReader is automatically closed
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println("First line of the file:");
                System.out.println(firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

