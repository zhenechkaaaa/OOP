package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CardTest {

    private Card card;

    @Test
    void getValueTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        assertEquals(9, card.getValue());
    }

    @Test
    void getSuitTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    void getRankTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        assertEquals(Rank.NINE, card.getRank());
    }

    @Test
    void copyTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        Card copy = new Card(card);

        assertEquals(card.getValue(), copy.getValue());
        assertEquals(card.getRank(), copy.getRank());
        assertEquals(card.getSuit(), copy.getSuit());
    }

    @Test
    void testToString() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        String expected = card.getRank() + " " + card.getSuit() + " (" + card.getValue() + ")";
        assertEquals(expected, card.toString());
    }
}