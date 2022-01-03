package com.company;

/**
 * Main class
 */
public class Main {


    public static void main(String[] args) {

        //Test games
        Tests.runTests();

        //Normal game
        normalGame(args);

    }


    /**
     * Start a normal game
     * Use a file sent as argument if it exists
     * Create a new deck otherwise
     * 
     * @param args: The command line arguments
     */
    public static void normalGame(String[] args) {
        Blackjack newGame = new Blackjack(args);
        newGame.play();
    }
}
