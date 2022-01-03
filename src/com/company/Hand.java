package com.company;

import java.util.ArrayList;


/**
 * Class Hand
 * Represents the hand of a player in the game
 *
 * ArrayList<Card> content: The content of the hand
 */
public class Hand {

    private final ArrayList<Card> content;


    /**
     * Creator for the class Hand
     * Initialize the ArrayList representing the hand as a new ArrayList
     */
    public Hand() {
        this.content = new ArrayList<>();
    }


    /**
     *
     * Get the score of the hand
     * Adding the values of all the cards in the hand
     *
     * @return score: The integer score of the hand
     */
    public int score() {
        int score = 0;

        for (Card x: content) {
            score += x.getValue();
        }

        return score;
    }


    /**
     * Add a card to the hand
     *
     * @param addedCard: The card to add
     */
    public void addCard(Card addedCard) {
        content.add(addedCard);
    }


    /**
     * Print the content of the hand
     * Format used: "card1, card2, ..., cardN"
     *
     * @return handContent: A String with the content of the hand
     */
    public String printContent() {
        String handContent = content.get(0).getName();

        for (int i = 1 ; i < content.size() ; i++) {
            handContent = handContent + ", " + content.get(i).getName();
        }

        return handContent;
    }
}
