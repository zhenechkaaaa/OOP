package ru.nsu.odnostorontseva.bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

/**
 * Representing a deck of cards in a game.
 * Provides functionality for creating, shuffling,
 * picking up cards, adding cards, and checking if the deck is empty.
 */
public class Deck {

    private final List<Card> deck;

    /**
     * creates a new deck of cards.
     *
     * @param makeDeck (Если true, создается полная колода из 52 карт.
     *                 Если false, создается пустая колода).
     */
    public Deck(boolean makeDeck) {
        deck = new ArrayList<Card>();
        if (makeDeck) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    /**
     * returns the list of cards in the deck.
     *
     * @return (список карт)
     */
    public List<Card> getCards() {
        return deck;
    }

    /**
     * Adding a card into the deck.
     *
     * @param card (карта которую нужно добавить)
     */
    public void addCard(Card card) {
        deck.add(card);
    }

    /**
     * takes the top card from the deck.
     *
     * @return (верхняя карта колоды).
     */
    public Card takeCard() {
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;
    }

    /**
     * shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    /**
     * checking to see if the deck is empty.
     *
     * @return (true, если колода пуста, иначе false).
     */
    public boolean empty() {
        return deck.isEmpty();
    }

    /**
     * cleans the deck.
     */
    public void emptyDeck() {
        deck.clear();
    }

    /**
     * adding cards from the specified list to the deck.
     *
     * @param cards (карты, которые нужно добавить).
     */
    public void addDeck(List<Card> cards) {
        deck.addAll(cards);
    }

    /**
     * forms a new deck of discarded cards.
     *
     * @param discard (колода сброшенных карт).
     */
    public void deckFromDiscard(Deck discard) {
        this.addDeck(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Карты закончились, "
                + "мы образовали новую колоду из сброшенных и перемешали её.");
    }

    /**
     * returns the number of cards remaining in the deck.
     *
     * @return количество оставшихся карт.
     */
    public int cardsLeft() {
        return deck.size();
    }

    /**
     * returns a string representation of the deck of cards.
     *
     * @return строковое представление колоды карт.
     */
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Card card : deck) {
            output.append(card);
            output.append('\n');
        }
        return output.toString();
    }
}
