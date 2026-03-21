package com.gla.exceptionalhandling;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) {
        File file = new File("data.txt"); // file to read

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
