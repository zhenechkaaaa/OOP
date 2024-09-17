package nsu.odnostorontseva;

/**
 * Main Game file.
 */
public class BlackJack{

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, loses, roundCounter;

    /**
     *
     * main method.
     */
    public BlackJack() {
        wins = 0;
        loses = 0;
        roundCounter = 1;

        deck = new Deck(true);
        discarded = new Deck(false);

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        startRound();
    }

    /**
     * pipipupu
     */
    private void startRound() {

        if(wins > 0 || loses > 0) {
            System.out.println();
            roundCounter++;
            System.out.println("Раунд " + roundCounter + ".");
            System.out.println("Чтобы выйти нажмите '8'.");
            System.out.println("Дилер раздал карты:");
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }
        else {
            System.out.println();
            System.out.println("Раунд " + roundCounter + ".");
            System.out.println("Дилер раздал карты:");
        }

        if(deck.cardsLeft() < 4) {
            deck.deckFromDiscard(discarded);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        player.showHand();
        dealer.showFirstHand();

        if(dealer.blackJack()) {
            dealer.showHand();
            if (player.blackJack()){
                System.out.println("У вас обоих блекджек. Ничья. Счёт "+ wins + ":" + loses);
                startRound();
            }
            else {
                loses++;
                System.out.println("У дилера блекджек. Вы проиграли раунд. Счёт "+ wins + ":" + loses + ".");
                startRound();
            }
        }

        if(player.blackJack()) {
            wins++;
            System.out.println("У вас блекджек! Вы выиграли! Счёт " + wins + ":" + loses + ".");
            startRound();
        }

        player.decision(deck, discarded);

        if(player.getHand().countValues() > 21) {
            loses++;
            System.out.println("Вы проиграли раунд. Счёт " + wins + ":" + loses + ".");
            startRound();
        }

        dealer.showHand();
        while (dealer.getHand().countValues() < 17) {
            dealer.hit(deck, discarded);
        }

        if(dealer.getHand().countValues() > 21) {
            wins ++;
            System.out.println("Вы выиграли раунд! Счёт " + wins + ":" + loses + ".");
        }

        else if(dealer.getHand().countValues() > dealer.getHand().countValues()) {
            loses++;
            System.out.println("Вы проиграли раунд. Счёт " + wins + ":" + loses + ".");
        }

        else if(player.getHand().countValues() > dealer.getHand().countValues()) {
            wins++;
            System.out.println("Вы выиграли раунд! Счёт " + wins + ":" + loses + ".");
        }
        else{
            System.out.println("Ничья. Счёт "+ wins + ":" + loses + ".");
        }
        startRound();
    }
}
