package ru.nsu.odnostorontseva.bj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//идея взята отсюда https://www.baeldung.com/java-junit-testing-system-in

class PlayerTest {

    private Player player;
    private Deck deck;
    private Deck discard;

    @BeforeEach
    public void setUp() {
        player = new Player();
        deck = new Deck(true);
        discard = new Deck(false);
        Hand hand = new Hand();

        player.setHand(hand);
    }

    @Test
    void playerRoleTest() {
        Player player = new Player();
        assertEquals("Игрок", player.getRole());
    }

    @Test
    void testDecisionHit() {
        String input = "1\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        player.decision(deck, discard, scanner);

        // Проверяем, что у игрока есть карты после того, как он выбрал "взять карту"
        assertTrue(player.getHand().countValues() > 0);
    }

    @Test
    void testDecisionStop() {
        String input = "0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        player.decision(deck, discard, scanner);
        assertEquals(0, player.getHand().countValues());
    }

    @Test
    void testInvalidInput() {
        String input = "error\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        player.decision(deck, discard, scanner);
        assertEquals(0, player.getHand().countValues());
    }
}