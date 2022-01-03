package com.company;


/**
 * Class Card
 * Represents one card in the game, carrying a name and a value
 * Numerical cards have their number as value
 * Aces have 11 as value
 * Heads have 10 as value
 *
 * String name: The name of the card
 * int value: The value of the card
 */
public class Card {

    String name;
    int value;


    /**
     * Constructor for the class Card
     * Takes the name of a card as a String and compute the value of the card from it
     *
     * @param name: The name of the card as a String
     */
    public Card(String name) {
        this.name = name;
        this.value = computeValue();
    }


    /**
     * Compute the value of a card based on its name
     * For numerical cards, the value is the digit on the card
     * For head cards the value is 10
     * For aces the value is 11
     *
     * @return value: the value of the card
     */
    private int computeValue() {
        int value;
        if (Character.isDigit(name.charAt(1)) && name.length() == 2) {
            value = Character.getNumericValue(name.charAt(1));
        }
        else if (name.charAt(1) == 'A') {
            value = 11;
        }
        else {
            value = 10;
        }

        return value;
    }


    /**
     * Getter for the name of the card
     *
     * @return name: The name of the card as a String
     */
    public String getName() {
        return name;
    }


    /**
     * Getter for the value of the card
     *
     * @return value: The value of the card as an integer
     */
    public int getValue() {
        return value;
    }
}
