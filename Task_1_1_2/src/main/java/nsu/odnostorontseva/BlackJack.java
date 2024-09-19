package nsu.odnostorontseva;

import java.util.Scanner;

/**
 * Main Game class that simulates a simple game of Blackjack between a player and a dealer.
 * It handles the game flow, player and dealer actions, and keeps track of the score.
 */
public class BlackJack {

    private final Deck deck;
    private final Deck discarded;
    private final Dealer dealer;
    private final Player player;
    private int wins;
    private int loses;
    private int nobody;
    private int roundCounter;
    boolean gameOver;

    /**
     * initializing the game state and starts the game.
     * It initializes the decks, shuffles the cards, and sets up the player and dealer.
     */
    public BlackJack() {
        wins = 0;
        loses = 0;
        nobody = 0;
        roundCounter = 1;
        gameOver = false;

        deck = new Deck(true);
        discarded = new Deck(false);

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        playGame();
    }

    /**
     * main game loop that controls the flow of the game.
     * before each round, the player is asked if they want to continue playing.
     * if the player chooses not to continue, the game ends.
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            // Спрашиваем, хочет ли пользователь продолжить перед каждым раундом
            System.out.println();
            System.out.println("Хотите начать новый раунд? y/n");
            String input = scanner.next();
            if (input.equals("n")) {
                gameOver = true;
                System.out.println("Спасибо за игру! Игра завершена.");
                break;
            } else if (input.equals("y")) {
                startRound(scanner);
            }
        }
        scanner.close();
    }


    /**
     * starts a new round of Blackjack.
     * this method handles the card dealing,
     * player and dealer actions, and determines the result of the round.
     *
     * @param scanner (сканер для пользовательского ввода).
     */
    public void startRound(Scanner scanner) {
        if (wins > 0 || loses > 0 || nobody > 0) {
            roundCounter++;
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        if (deck.cardsLeft() < 4) {
            deck.deckFromDiscard(discarded);
        }

        System.out.println("Раунд " + roundCounter + ".");
        System.out.println("Дилер раздал карты:");

        //раздача карт
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        player.showHand();
        dealer.showFirstHand();

        //проверка на блекджек
        if (dealer.blackJack()) {
            dealer.showHand();
            if (player.blackJack()) {
                nobody++;
                System.out.println("У вас обоих блекджек. Ничья. Счёт " + wins + ":" + loses);
                System.out.println();
            } else {
                loses++;
                System.out.println("У дилера блекджек. Вы проиграли раунд. " +
                        "Счёт " + wins + ":" + loses + ".");
            }
            return;
        }

        if (player.blackJack()) {
            wins++;
            System.out.println("У вас блекджек! Вы выиграли! Счёт " + wins + ":" + loses + ".");
            return;
        }

        //ход игрока
        player.decision(deck, discarded, scanner);

        if (player.getHand().countValues() > 21) {
            loses++;
            System.out.println("Вы проиграли раунд. Счёт " + wins + ":" + loses + ".");
            return;
        }

        //ход дилера
        dealer.showHand();
        while (dealer.getHand().countValues() < 17) {
            dealer.hit(deck, discarded);
        }

        //проверка результатов раунда
        if (dealer.getHand().countValues() > 21) {
            wins++;
            System.out.println("Вы выиграли раунд! Счёт " + wins + ":" + loses + ".");
        } else if (dealer.getHand().countValues() > player.getHand().countValues()) {
            loses++;
            System.out.println("Вы проиграли раунд. Счёт " + wins + ":" + loses + ".");
        } else if (player.getHand().countValues() > dealer.getHand().countValues()) {
            wins++;
            System.out.println("Вы выиграли раунд! Счёт " + wins + ":" + loses + ".");
        } else {
            nobody++;
            System.out.println("Ничья. Счёт " + wins + ":" + loses + ".");
        }
    }
}
