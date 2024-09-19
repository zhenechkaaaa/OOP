package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    private testPerson person;
    private Deck deck;
    private Deck discard;
    private Hand hand;

    // A simple subclass of Person to test abstract class functionality.
    static class testPerson extends Person {
        public testPerson() {
            super();
            this.setRole("Тестовый игрок");
        }
    }

    @BeforeEach
    void setUp() {
        person = new testPerson();

        deck = new Deck(true);
        discard = new Deck(false);
        hand = new Hand();

        person.setHand(hand);
    }

    @Test
    void getHandTest() {
        assertEquals(0, person.getHand().countValues());

        hand.takeCardFromDeck(deck);
        assertTrue(person.getHand().countValues() > 0);
    }

    @Test
    void setHandTest() {
        Hand hand2 = new Hand();
        hand2.takeCardFromDeck(deck);
        person.setHand(hand2);

        assertTrue(person.getHand().countValues() > 0);
    }

    @Test
    void getRoleTest() {
        assertEquals("Тестовый игрок", person.getRole());
    }

    @Test
    void setRoleTest() {
        person.setRole("Билибобка");
        assertEquals("Билибобка", person.getRole());
    }

    @Test
    void blackJackTestTrue() {
        Deck deck2 = new Deck(false);
        deck2.addCard(new Card(Suit.CLUBS, Rank.ACE));
        deck2.addCard(new Card(Suit.SPADES, Rank.JACK));

        hand.takeCardFromDeck(deck2);
        hand.takeCardFromDeck(deck2);

        assertTrue(person.blackJack());
    }

    @Test
    void blackJackTestFalse() {
        Deck deck1 = new Deck(false);
        deck1.addCard(new Card(Suit.CLUBS, Rank.ACE));
        deck1.addCard(new Card(Suit.SPADES, Rank.SIX));

        hand.takeCardFromDeck(deck1);
        hand.takeCardFromDeck(deck1);

        assertFalse(person.blackJack());
    }

    @Test
    void showHandTest() {
        Deck deck1 = new Deck(false);
        deck1.addCard(new Card(Suit.CLUBS, Rank.ACE));
        deck1.addCard(new Card(Suit.SPADES, Rank.SIX));

        hand.takeCardFromDeck(deck1);
        hand.takeCardFromDeck(deck1);

        person.showHand();
    }

    @Test
    void hitWithEmptyDisTest() {
        Deck deck1 = new Deck(false);
        deck1.addCard(new Card(Suit.CLUBS, Rank.ACE));
        person.hit(deck1, discard);

        assertEquals(11, person.getHand().countValues());
    }

    @Test
    void hitWithNotEmptyDisTest() {
        Deck deck1 = new Deck(false);
        discard.addCard(new Card(Suit.CLUBS, Rank.ACE));
        person.hit(deck1, discard);

        assertEquals(11, person.getHand().countValues());
    }
}