package nsu.odnostorontseva;

import java.util.Objects;

/**
 * representing a player in a game.
 * Provides common methods and properties for all players,
 * including hand, role, and actions such as scoring,
 * showing a hand and taking a card.
 */
public abstract class Person {

    private Hand hand;
    private String role;

    /**
     * constructing the Person class, initializing the hand and role.
     */
    public Person() {
        this.hand = new Hand();
        this.role = "";
    }

    /**
     * returns person's hand.
     *
     * @return карты на руке.
     */
    public Hand getHand() {
        return this.hand;
    }

    /**
     * sets the person's hand.
     *
     * @param hand (новая рука).
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * return person's role.
     *
     * @return роль игрока(дилер или игрок).
     */
    public String getRole() {
        return this.role;
    }

    /**
     * sets person's role.
     *
     * @param role (роль игрока).
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * checks to see if the player has blackjack.
     *
     * @return true, если у игрока блэкджек, иначе false.
     */
    public boolean blackJack() {
        return this.getHand().countValues() == 21;
    }

    /**
     * shows information about the person's hand,
     * including cards and point.
     */
    public void showHand() {
        System.out.print("Карты " + this.role + "а: ");
        System.out.println("[" + this.hand + "] => " + this.hand.countValues());
    }

    /**
     * takes a card from the deck.
     * checking to see if a new deck needs to be formed from the discarded cards.
     *
     * @param deck    (колода).
     * @param discard (сброшенные карты).
     */
    public void hit(Deck deck, Deck discard) {
        if (deck.empty()) {
            deck.deckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        if (Objects.equals(this.role, "Игрок")) {
            System.out.println("Вы открыли карту: " + this.hand.getLastEdedCard());
        } else {
            System.out.println("Дилер открывает карту: " + this.hand.getLastEdedCard());
        }

        this.showHand();
    }
}
