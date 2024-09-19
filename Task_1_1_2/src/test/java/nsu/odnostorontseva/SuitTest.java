package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SuitTest {

    @Test
    void testToString() {
        assertEquals("Черви", Suit.HEARTS.toString());
        assertEquals("Трефы", Suit.CLUBS.toString());
        assertEquals("Бубны", Suit.DIAMONDS.toString());
        assertEquals("Пики", Suit.SPADES.toString());
    }

}