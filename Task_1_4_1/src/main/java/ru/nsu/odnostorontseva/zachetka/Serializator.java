package ru.nsu.odnostorontseva.zachetka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class for serializing and deserializing Students.
 */
public class Serializator {

    /**
     * Serializes a Student to a specified file.
     *
     * @param student the object to serialize.
     * @param file the file where the serialized object will be stored.
     * @return if the serialization was successful.
     * @throws IOException if an I/O error occurs during serialization.
     */
    public boolean serialization(Student student, File file) throws IOException {

        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    /**
     * Deserializes a student from a specified file.
     *
     * @param file the file containing the serialized student.
     * @return the deserialized object.
     * @throws IOException if an I/O error occurs during deserialization.
     * @throws RuntimeException if the class of the serialized object cannot be found.
     */
    public Student deserialization(File file) throws IOException {
        ObjectInputStream objectInputStream = null;
        Student student;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            student = (Student) objectInputStream.readObject();
            fileInputStream.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }
        return student;
    }
}
