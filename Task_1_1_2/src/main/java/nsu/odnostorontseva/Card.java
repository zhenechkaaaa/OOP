package nsu.odnostorontseva;

/**
 *
 */
public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * assigns a suit and rank to a card.
     *
     * @param suit (передаёт масть)
     * @param rank (передаёт ранг)
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

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
     * Copy constructor to create a new card with the same suit and rank.
     *
     * @param card (карта которую нужно скопировать).
     */
    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    /**
     * Returns a string representation of the card in the format “rank suit (value)”.
     *
     * @return (строковое представление карты).
     */
    public String toString() {
        return (rank+" "+ suit + " ("+this.getValue()+")");
    }
}
