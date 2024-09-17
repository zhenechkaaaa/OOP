package nsu.odnostorontseva;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//идея взята отсюда https://www.baeldung.com/java-junit-testing-system-in

class PlayerTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    private Player player;
    private Deck deck;
    private Deck discard;

    @BeforeEach
    public void setUp() {
        player = new Player();
        deck = new Deck(true);
        discard = new Deck(false);
    }

    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    //@Test
    //void testDecisionHit() {
    //    // Подменяем ввод пользователя, чтобы он выбрал "взять карту"
    //    provideInput("1");
//
    //    // Вызываем метод решения
    //    player.decision(deck, discard);
//
    //    // Проверяем, что у игрока есть карты после того, как он выбрал "взять карту"
    //    assertTrue(player.getHand().countValues() > 0);
    //}

    @Test
    void testPlayerConstructor() {
        Player player = new Player();
        assertEquals("Игрок", player.getRole());
    }


}