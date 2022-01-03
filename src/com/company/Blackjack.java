package com.company;

import java.util.LinkedList;


/**
 * Class blackjack
 *
 * Represents a game of blackjack
 *
 * Deck deck: The deck used in the game
 * Hand samHand: The hand of the player sam
 * Hand dealerHand: The hand of the dealer
 * String winner: The winner of the game
 */
public class Blackjack {

    private final Deck deck;
    private final Hand samHand;
    private final Hand dealerHand;
    private String winner;


    /**
     * Creator for the class Blackjack
     * Initialize the deck from a file sent as argument or create a new one if no file were sent
     * Initialize hands for both players
     * Put the winner as to be decided
     *
     * @param args: The address of the deck file
     */
    public Blackjack(String[] args) {
        if (args.length ==  0) {
            this.deck = new Deck();
        }
        else {
            this.deck = new Deck(args[0]);
        }
        this.samHand = new Hand();
        this.dealerHand = new Hand();
        this.winner = "To be decided";
    }


    /**
     * Creator for the class Blacjack
     * Initialize the deck from a deck sent as parameter
     * Initialize a hand for both players
     * Set the winner to be decided
     * Meant for testing
     *
     * @param deckTest: The deck meant to be tested
     */
    public Blackjack(LinkedList<Card> deckTest) {
        this.deck = new Deck(deckTest);
        this.samHand = new Hand();
        this.dealerHand = new Hand();
        this.winner = "To be decided";
    }


    /**
     * Play a game
     * First initialize the game and check if someone won
     * Then if no one won, Sam plays and check if someone lost or won
     * Then if not, Dealer plays and check if someone lost or won
     * Then if not, check the scores and find the winner
     */
    public void play() {
        initializeGame();
        if (initializeWinner()) {
            printOutput();
        }
        else {
            samPlay();
            if (someoneLost()) {
                printOutput();
            }
            else {
                dealerPlay();
                if (someoneLost()) {
                    printOutput();
                }
                else {
                    countWin();
                    printOutput();
                }
            }
        }
    }


    /**
     * Initialize the game by making both players draw two cards
     */
    private void initializeGame() {
        samHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        samHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }


    /**
     * Check if someone won after initialization
     *
     * @return finish: true if the game is finished, false otherwise
     */
    private boolean initializeWinner() {

        boolean finish;

        if (samHand.score() == 21) {
            winner = "sam";
            finish = true;
        }
        else if (dealerHand.score() == 21) {
            winner = "dealer";
            finish = true;
        }
        else {
            finish = someoneLost();
        }
        if (samHand.score() == 22 && dealerHand.score() == 22) {
            winner = "dealer";
            finish = true;
        }

        return finish;
    }


    /**
     * Sam plays and draw cards until his score is above 17
     */
    private void samPlay() {
        while (samHand.score() < 17) {
            samHand.addCard(deck.drawCard());
        }
    }


    /**
     * Dealer plays and draw cards until his score is above Sam's
     */
    private void dealerPlay() {
        while (dealerHand.score() <= samHand.score()) {
            dealerHand.addCard(deck.drawCard());
        }
    }


    /**
     * Count the score of both players
     * The winner is the one with the higher score
     */
    private void countWin() {
        if (samHand.score() > dealerHand.score()) {
            winner = "sam";
        }
        else {
            winner = "dealer";
        }
    }


    /**
     * Check if someone lost the game by getting above 21
     *
     * @return finish: true if the game is finished, false otherwise
     */
    private boolean someoneLost() {

        boolean finish = false;

        if (samHand.score() > 21) {
            winner = "dealer";
            finish = true;
        }
        if (dealerHand.score() > 21) {
            winner = "sam";
            finish = true;
        }

        return finish;
    }


    /**
     * Print the output of the current game
     * The output is the name of the winner and the hands of both players
     */
    private void printOutput() {
        System.out.println(winner);
        System.out.println("sam: " + samHand.printContent());
        //System.out.println("sam: " + samHand.printContent() + " ; score: " + samHand.score());
        System.out.println("dealer: " + dealerHand.printContent());
        //System.out.println("dealer: " + dealerHand.printContent() + " ; score: " + dealerHand.score());
    }
}
