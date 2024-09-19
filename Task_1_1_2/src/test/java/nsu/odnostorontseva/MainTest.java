package nsu.odnostorontseva;

import org.junit.jupiter.api.Test;
import nsu.odnostorontseva.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            System.out.println("error");
        } finally {
            System.setOut(originalOutput);
        }
    }
}