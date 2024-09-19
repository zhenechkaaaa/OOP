package nsu.odnostorontseva;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    void testToString() {
        assertEquals("Туз", Rank.ACE.toString());
        assertEquals("Двойка", Rank.TWO.toString());
        assertEquals("Тройка", Rank.THREE.toString());
        assertEquals("Четвёрка", Rank.FOUR.toString());
        assertEquals("Пятёрка", Rank.FIVE.toString());
        assertEquals("Шестёрка", Rank.SIX.toString());
        assertEquals("Семёрка", Rank.SEVEN.toString());
        assertEquals("Восьмёрка", Rank.EIGHT.toString());
        assertEquals("Девятка", Rank.NINE.toString());
        assertEquals("Десятка", Rank.TEN.toString());
        assertEquals("Валет", Rank.JACK.toString());
        assertEquals("Дама", Rank.QUEEN.toString());
        assertEquals("Король", Rank.KING.toString());
    }
}