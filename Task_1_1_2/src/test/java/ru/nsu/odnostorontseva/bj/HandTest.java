package ru.nsu.odnostorontseva.bj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class HandTest {

    private Hand hand;
    private Deck deck;
    private Deck discarded;

    @Test
    void takeCardFromDeckTest() {
        hand = new Hand();
        deck = new Deck(false);
        Card card = new Card(Suit.SPADES, Rank.SEVEN);
        deck.addCard(card);

        hand.takeCardFromDeck(deck);

        assertEquals(card.getValue(), hand.getCard(0).getValue());
    }

    @Test
    void countValuesTest() {
        hand = new Hand();
        deck = new Deck(false);

        Card card0 = new Card(Suit.SPADES, Rank.SEVEN);
        deck.addCard(card0);
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        deck.addCard(card1);

        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);

        int expected = 18;
        assertEquals(expected, hand.countValues());

        Card card2 = new Card(Suit.CLUBS, Rank.ACE);
        deck.addCard(card2);

        hand.takeCardFromDeck(deck);
        expected = 19;
        assertEquals(expected, hand.countValues());
    }

    @Test
    void getLastAddedCardTest() {
        hand = new Hand();
        deck = new Deck(false);

        Card card0 = new Card(Suit.SPADES, Rank.SEVEN);
        deck.addCard(card0);
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        deck.addCard(card1);

        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);

        assertEquals(card1.getValue(), hand.getLastAddedCard().getValue());
    }

    @Test
    void getLastAddedCardTestEmptyHand() {
        hand = new Hand();
        assertNull(hand.getLastAddedCard());
    }

    @Test
    void discardHandToDeckTest() {
        hand = new Hand();
        deck = new Deck(false);
        discarded = new Deck(false);

        Card card0 = new Card(Suit.SPADES, Rank.SEVEN);
        deck.addCard(card0);
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        deck.addCard(card1);

        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);

        hand.discardHandToDeck(discarded);

        assertEquals(0, hand.countValues());

        assertEquals(card0.getValue(), discarded.takeCard().getValue());
        assertEquals(card1.getValue(), discarded.takeCard().getValue());
    }

    @Test
    void testToString() {
        hand = new Hand();
        deck = new Deck(false);
        Card card = new Card(Suit.SPADES, Rank.SEVEN);
        deck.addCard(card);

        hand.takeCardFromDeck(deck);

        String expected = "Семёрка Пики (7)";
        assertEquals(expected, hand.toString());
    }
}