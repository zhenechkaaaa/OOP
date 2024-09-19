package nsu.odnostorontseva;

import java.util.ArrayList;

/**
 * represents a player's hand in a game.
 * Provides functionality for taking cards,
 * scoring, resetting a hand,
 * and displaying hand information.
 */
public class Hand {
    private final ArrayList<Card> hand;

    /**
     * creating a new empty hand.
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * takes a card from the deck and adds it to the hand.
     *
     * @param deck (колода, из которой берется карта).
     */
    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    /**
     * counts the sum of the points in the hand,
     * taking into account the rules for counting aces.
     *
     * @return сумма очков.
     */
    public int countValues() {
        int val = 0;
        int aceCnt = 0;
        for (Card card : hand) {
            val += card.getValue();
            if (card.getValue() == 11) {
                aceCnt++;
            }
        }

        if (val > 21 && aceCnt > 0) {
            while (aceCnt > 0 && val > 21) {
                aceCnt--;
                val -= 10;
            }
        }
        return val;
    }

    /**
     * returns a card with the given index from the hand.
     *
     * @param id (номер карты в руке).
     * @return карта под этим индексом.
     */
    public Card getCard(int id) {
        return hand.get(id);
    }

    /**
     * returns the last card added to the hand.
     *
     * @return последняя взятая карта.
     */
    public Card getLastEdedCard() {
        return hand.get(hand.size() - 1);
    }

    /**
     * discards all cards from your hand into the discard deck.
     *
     * @param discard (колода сброса)
     */
    public void discardHandToDeck(Deck discard) {
        discard.addDeck(hand);
        hand.clear();
    }

    /**
     * returns a string representation of the hand.
     *
     * @return карты на руке.
     */
    public String toString() {
        String output = "";
        for (int counter = 0; counter < (hand.size() - 1); counter++) {
            Card card = hand.get(counter);
            output += card + ", ";
        }
        output += hand.get(hand.size() - 1);
        return output;
    }
}
