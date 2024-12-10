package ru.nsu.odnostorontseva.zachetka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.Test;

class SerializatorTest {

    @Test
    void serializationTest() throws Exception {
        Student newStudent = new Student("Platnik Vasya", true);
        File file = new File("./student.data");
        Serializator serializator = new Serializator();
        boolean flag = serializator.Serialization(newStudent, file);
        file.deleteOnExit();
        assertTrue(flag);
    }

    @Test
    void deserializationTest() throws Exception {
        Student newStudent = new Student("Platnik Vasya", true);
        File file = new File("./student.data");
        Serializator serializator = new Serializator();
        boolean flag = serializator.Serialization(newStudent, file);
        if (flag) {
            assertEquals(newStudent, serializator.Deserialization(file));
        }
        file.deleteOnExit();
    }
}