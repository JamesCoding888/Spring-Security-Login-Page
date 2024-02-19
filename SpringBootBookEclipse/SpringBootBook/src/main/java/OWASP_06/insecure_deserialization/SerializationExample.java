package OWASP_06.insecure_deserialization;
/*
 * Serialization and deserialization are processes used to convert an object into a byte stream 
 * and then reconstructing the object from that byte stream, respectively. 
 * 
 * In Java, this is commonly done using the java.io.Serializable interface and the ObjectInputStream 
 * and ObjectOutputStream classes.
 * 
 */

import java.io.*;

// Define a class that implements Serializable
class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    // Constructor
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object of MyClass
        MyClass obj = new MyClass("John", 30);

        // Serialization
        try {
            // Creating a FileOutputStream
            FileOutputStream fileOut = new FileOutputStream("myclass.ser");
            // Creating an ObjectOutputStream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Writing the object to the ObjectOutputStream
            out.writeObject(obj);
            // Closing the streams
            out.close();
            fileOut.close();
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        MyClass newObj = null;
        try {
            // Creating a FileInputStream
            FileInputStream fileIn = new FileInputStream("myclass.ser");
            // Creating an ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // Reading the object from the ObjectInputStream
            newObj = (MyClass) in.readObject();
            // Closing the streams
            in.close();
            fileIn.close();
            System.out.println("Object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Displaying the deserialized object
        if (newObj != null) {
            System.out.println("Deserialized Object:");
            System.out.println("Name: " + newObj.getName());
            System.out.println("Age: " + newObj.getAge());
        }
    }
}
