package ru.nsu.odnostorontseva.bj;

/**
 * representing the ranks of cards in a card game.
 * each constant in the enumeration contains the name of the rank and its value.
 */
public enum Rank {
    ACE("Туз", 11),
    TWO("Двойка", 2),
    THREE("Тройка", 3),
    FOUR("Четвёрка", 4),
    FIVE("Пятёрка", 5),
    SIX("Шестёрка", 6),
    SEVEN("Семёрка", 7),
    EIGHT("Восьмёрка", 8),
    NINE("Девятка", 9),
    TEN("Десятка", 10),
    JACK("Валет", 10),
    QUEEN("Дама", 10),
    KING("Король", 10);

    final String rankName;
    final int rankValue;

    /**
     * constructing of a Rank enumeration.
     * initializing the name and value of the rank.
     *
     * @param rankName  (название ранга).
     * @param rankValue (сколько очков присвоено этому рангу).
     */
    Rank(String rankName, int rankValue) {
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    /**
     * returns a string representation of the rank.
     *
     * @return строковое представлением ранга.
     */
    //добавляем @Override, потому что метод toString() определён в классе Object
    // @Override показывает, что я переопределяю метод toString(), а не создаю новый.
    @Override
    public String toString() {
        return rankName;
    }
}
