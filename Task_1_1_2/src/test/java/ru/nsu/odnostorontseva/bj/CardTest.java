package ru.nsu.odnostorontseva.bj;

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
        assertEquals(Suit.DIAMONDS, card.suit());
    }

    @Test
    void getRankTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        assertEquals(Rank.NINE, card.rank());
    }

    @Test
    void copyTest() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        Card copy = new Card(card.suit(), card.rank());

        assertEquals(card.getValue(), copy.getValue());
        assertEquals(card.rank(), copy.rank());
        assertEquals(card.suit(), copy.suit());
    }

    @Test
    void testToString() {
        card = new Card(Suit.DIAMONDS, Rank.NINE);
        String expected = card.rank() + " " + card.suit() + " (" + card.getValue() + ")";
        assertEquals(expected, card.toString());
    }
}