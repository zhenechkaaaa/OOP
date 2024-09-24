package ru.nsu.odnostorontseva.bj;

/**
 *  representing the suits of cards in a game.
 *  each enumeration constant contains the suit name.
 */
public enum Suit {
    HEARTS("Черви"),
    CLUBS("Трефы"),
    DIAMONDS("Бубны"),
    SPADES("Пики");

    final String suitName;

    /**
     * constructing the suit enumeration.
     * initializes the suit name.
     *
     * @param suitName (масть).
     */
    Suit(String suitName) {
        this.suitName = suitName;
    }

    /**
     * returns a string representation of the suit.
     *
     * @return строковое значение масти.
     */
    public String toString() {
        return suitName;
    }
}
