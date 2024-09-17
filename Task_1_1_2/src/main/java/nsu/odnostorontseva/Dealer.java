package nsu.odnostorontseva;

/**
 * Representing the dealer in a game.
 * Inherits the Person class. *
 */
public class Dealer extends Person {

    /**
     * setting the “Dealer” role for the object.
     */
    public Dealer() {
        super.setRole("Дилер");
    }

    /**
     * Displays information about the dealer's first cards, hiding the second card.
     */
    public void showFirstHand() {
        System.out.print("Карты Дилера: ");
        System.out.print("[" + super.getHand().getCard(0) + ", ");
        System.out.println("<закрытая карта>]");
    }
}
