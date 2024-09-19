package nsu.odnostorontseva;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealerTest {
    private Dealer dealer;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    void dealerRoleTest() {
        dealer = new Dealer();
        assertEquals("Дилер", dealer.getRole());
    }

    @Test
    void showFirstHandTest() {
        System.setOut(new PrintStream(outputStream));

        dealer = new Dealer();
        Deck deck = new Deck(false);
        Card card0 = new Card(Suit.DIAMONDS, Rank.FIVE);
        Card card1 = new Card(Suit.CLUBS, Rank.FIVE);

        deck.addCard(card0);
        deck.addCard(card1);

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        dealer.showFirstHand();

        String output = outputStream.toString().trim();

        assertEquals(output, "Карты Дилера: [Пятёрка Бубны (5), <закрытая карта>]");

        outputStream.reset();
    }
}