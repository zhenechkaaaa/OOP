package ru.nsu.odnostorontseva.bj;


/**
 * representing a card in a game.
 *
 * @param suit (масть карты).
 * @param rank (достоинство карты).
 */
record Card(Suit suit, Rank rank) {
    /**
     * Shows how many points the card will give.
     *
     * @return (возвращает сколько очков даёт карта)
     */
    public int getValue() {
        return rank.rankValue;
    }

    /**
     * Returns a string representation of the card in the format “rank suit (value)”.
     *
     * @return (строковое представление карты).
     */
    //добавляем @Override, потому что метод toString() определён в классе Object
    // @Override показывает, что я переопределяю метод toString(), а не создаю новый.
    @Override
    public String toString() {
        return rank + " " + suit + " (" + this.getValue() + ")";
    }
}
