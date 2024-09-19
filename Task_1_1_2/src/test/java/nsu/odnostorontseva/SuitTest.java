package nsu.odnostorontseva;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SuitTest {

    @Test
    void testToString() {
        assertEquals("Черви", Suit.HEARTS.toString());
        assertEquals("Трефы", Suit.CLUBS.toString());
        assertEquals("Бубны", Suit.DIAMONDS.toString());
        assertEquals("Пики", Suit.SPADES.toString());
    }

}