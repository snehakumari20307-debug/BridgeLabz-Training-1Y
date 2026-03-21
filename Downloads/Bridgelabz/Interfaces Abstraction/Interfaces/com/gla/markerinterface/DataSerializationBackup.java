package com.gla.markerinterface;
import java.io.*;

// Marker interface in Java
class DataSerializationBackup {
    public static void main(String[] args) {
        try {
            // Create object to backup
            User user = new User("Rahul", 25);

            // Serialize object
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user); // only works because User implements Serializable
            out.close();
            fileOut.close();

            System.out.println("User object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Class marked Serializable
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

