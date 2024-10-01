package ru.nsu.odnostorontseva.bj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void mainTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;
        System.setOut(new PrintStream(output));

        try {
            Main.main(new String[]{});

            String out = output.toString();
            assertEquals("Добро пожаловать в BlackJack!", out);
        } catch (Exception e) {
            System.err.println("error");
        } finally {
            System.setOut(originalOutput);
        }
    }
}