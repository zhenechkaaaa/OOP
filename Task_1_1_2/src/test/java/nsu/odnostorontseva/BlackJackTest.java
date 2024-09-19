package nsu.odnostorontseva;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackJackTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testGameLoop() {
        String input = "y\n0\nn\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BlackJack game = new BlackJack();

        game.playGame();

        String output = outputStream.toString();
        assertTrue(output.contains("Хотите начать новый раунд? y/n"));
        assertTrue(output.contains("Раунд 1."));
        assertTrue(output.contains("Спасибо за игру! Игра завершена."));
    }

    @Test
    void gameOverTest() {
        String input = "n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BlackJack game = new BlackJack();

        game.playGame();

        String output = outputStream.toString();
        assertTrue(output.contains("Спасибо за игру! Игра завершена."));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}