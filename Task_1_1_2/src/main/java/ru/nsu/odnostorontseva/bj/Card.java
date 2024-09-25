package ru.nsu.odnostorontseva.bj;


/**
 * representing a card in a game.
 *
 * @param suit (масть карты).
 * @param rank (достоинство карты).
 */
public record Card(Suit suit, Rank rank) {
    /**
     * Shows how many points the card will give.
     *
     * @return (возвращает сколько очков даёт карта)
     */
    public int getValue() {
        return rank.rankValue;
    }

    /**
     * returns the card's suit.
     *
     * @return (возвращает масть)
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * returns the card's rank.
     *
     * @return (возвращает ранг).
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns a string representation of the card in the format “rank suit (value)”.
     *
     * @return (строковое представление карты).
     */
    public String toString() {
        return rank + " " + suit + " (" + this.getValue() + ")";
    }
}
