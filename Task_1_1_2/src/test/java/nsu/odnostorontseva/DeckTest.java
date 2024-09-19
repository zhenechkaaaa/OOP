package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

    private Deck deck;
    private Deck emptyDeck;

    @BeforeEach
    void setUp() {
        deck = new Deck(true);
        emptyDeck = new Deck(false);
    }

    @Test
    void creatingFullDeckTest() {
        assertEquals(52, deck.cardsLeft());
    }

    @Test
    void creatingEmptyDeckTest() {
        assertEquals(0, emptyDeck.cardsLeft());
    }

    @Test
    void addCardsTest() {
        emptyDeck.addCard(new Card(Suit.SPADES, Rank.SIX));
        assertEquals(1, emptyDeck.cardsLeft());
    }

    @Test
    void takeCardTest() {
        Card card0 = new Card(Suit.SPADES, Rank.SEVEN);
        emptyDeck.addCard(card0);

        Card expected = emptyDeck.takeCard();
        assertEquals(expected.getValue(), card0.getValue());
        assertEquals(0, emptyDeck.cardsLeft());
    }

    @Test
    void shuffleTest() {
        deck.shuffle();
        assertEquals(52, deck.cardsLeft());
    }

    @Test
    void emptyTest() {
        assertTrue(emptyDeck.empty());
        assertFalse(deck.empty());
    }

    @Test
    void emptyDeckTest() {
        deck.emptyDeck();
        assertTrue(deck.empty());
        assertEquals(0, deck.cardsLeft());
    }

    @Test
    void addDeckTest() {
        ArrayList<Card> newCards = new ArrayList<>();
        Card card0 = new Card(Suit.CLUBS, Rank.FIVE);
        Card card1 = new Card(Suit.CLUBS, Rank.NINE);

        newCards.add(card0);
        newCards.add(card1);

        emptyDeck.addDeck(newCards);

        assertEquals(2, emptyDeck.cardsLeft());
        assertEquals(card0.getValue(), emptyDeck.getCards().get(0).getValue());
        assertEquals(card1.getValue(), emptyDeck.getCards().get(1).getValue());
    }

    @Test
    void deckFromDiscardTest() {
        emptyDeck.deckFromDiscard(deck);
        assertTrue(deck.empty());
        assertFalse(emptyDeck.empty());
        assertEquals(52, emptyDeck.cardsLeft());
    }

    @Test
    void cardsLeftTest() {
        assertEquals(52, deck.cardsLeft());
        deck.takeCard();
        assertEquals(51, deck.cardsLeft());
    }

    @Test
    void testToString() {
        emptyDeck.addCard(new Card(Suit.CLUBS, Rank.NINE));

        String expected = "Девятка Трефы (9)\n";
        assertEquals(expected, emptyDeck.toString());
    }
}