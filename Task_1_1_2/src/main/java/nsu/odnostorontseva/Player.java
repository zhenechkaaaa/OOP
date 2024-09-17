package nsu.odnostorontseva;

import java.util.Objects;
import java.util.Scanner;

/**
 * representing a player in a game.
 * inherits the Person class.
 * adds logic for decision making.
 */
public class Player extends Person {

    Scanner input = new Scanner(System.in);

    /**
     * constructing a Player class.
     * establishes the “Player” role for the object.
     */
    public Player() {
        super.setRole("Игрок");
    }

    /**
     * implements the logic of the player's decision making.
     * hit or stop.
     *
     * @param deck (колода).
     * @param discard (сброшенные карты).
     */
    public void decision(Deck deck, Deck discard) {
        String inputStr = "";
        boolean getNum = true;

        while (getNum){
            try{
                System.out.println("Введите '1', чтобы взять карту, и '0', чтобы остановиться...");
                inputStr = input.next();

                if (!Objects.equals(inputStr, "1") && !Objects.equals(inputStr, "0")) {
                    throw new IllegalArgumentException("Некорректный ввод. Попробуйте снова.");
                }

                getNum = false;
            }
            catch (IllegalArgumentException e) {
                System.out.println("ОШИБКА");
                input.next();
            }
        }

        int in = Integer.parseInt(inputStr);

        if (in == 1) {
            this.hit(deck, discard);

            if(this.getHand().countValues() > 20) {
                return;
            }

            else {
                this.decision(deck, discard);
            }
        }
        else {
            System.out.println();
        }
    }
}
