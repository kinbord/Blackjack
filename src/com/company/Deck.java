package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Class Deck
 * Represents a deck of card
 * The deck can be read from a file
 * If not the deck is generated as a new 52 cards deck and then shuffled
 *
 * LinkedList<Card> content: A list of card representing the content of deck
 * int size: The size of the deck
 */
public class Deck {

    private final LinkedList<Card> content;
    private int size;


    /**
     * Creator for the class Deck
     * Create a new deck from scratch
     */
    public Deck() {
        this.content = newRandomDeck();
        this.size = content.size();
    }


    /**
     * Creator for the class Deck
     * Create a deck sent as a parameter
     * Meant for testing
     *
     * @param testDeck: The deck meant to be tested
     */
    public Deck(LinkedList<Card> testDeck) {
        this.content = testDeck;
        this.size = content.size();
    }


    /**
     * Creator for the class Deck
     * Create a new deck from a file sent as a String
     *
     * @param file: The String representing the address of the file
     */
    public Deck(String file) {
        this.content = readDeckFromFile(file);
        this.size = content.size();
    }


    /**
     * Creator for the class Deck
     * Read a deck from a file using a scanner
     * Read the file as a String and parse it using ", " as a delimiter
     *
     * @return deckFromFile: The deck of card made from the file
     */
    private static LinkedList<Card> readDeckFromFile(String file) {

        LinkedList<Card> deckFromFile = new LinkedList<>();

        try {
            Card card;
            File fileRead = new File(file);
            Scanner myReader = new Scanner(fileRead);
            myReader.useDelimiter(", ");

            while (myReader.hasNext()) {
                String data = myReader.next();
                card = new Card(data);
                deckFromFile.add(card);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while trying to open a file.");
            e.printStackTrace();
        }

        return deckFromFile;
    }


    /**
     * Initiate a new deck of card
     * and then shuffle it
     *
     * @return newDeck: the new deck shuffled
     */
    private static LinkedList<Card> newRandomDeck() {

        LinkedList<Card> newDeck = new LinkedList<>();

        Card card = new Card("CA");
        newDeck.add(card);

        for(int i = 1 ; i < 52 ; i++) {
            if(i/13 == 0) {
                    if(i%13+1 == 11) {
                        card = new Card("CJ");
                        newDeck.add(card);
                    }
                    else if(i%13+1 == 12) {
                        card = new Card("CQ");
                        newDeck.add(card);
                    }
                    else if(i%13+1 == 13) {
                        card = new Card("CK");
                        newDeck.add(card);
                    }
                    else {
                        card = new Card("C" + (i%13+1));
                        newDeck.add(card);
                    }
            }
            else if(i/13 == 1) {
                    if (i % 13 + 1 == 1) {
                        card = new Card("DA");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 11) {
                        card = new Card("DJ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 12) {
                        card = new Card("DQ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 13) {
                        card = new Card("DK");
                        newDeck.add(card);
                    } else {
                        card = new Card("D" + (i % 13 + 1));
                        newDeck.add(card);
                    }
            }
            else if(i/13 == 2) {
                    if (i % 13 + 1 == 1) {
                        card = new Card("HA");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 11) {
                        card = new Card("HJ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 12) {
                        card = new Card("HQ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 13) {
                        card = new Card("HK");
                        newDeck.add(card);
                    } else {
                        card = new Card("H" + (i % 13 + 1));
                        newDeck.add(card);
                    }
            }
            else if(i/13 == 3) {
                    if (i % 13 + 1 == 1) {
                        card = new Card("SA");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 11) {
                        card = new Card("SJ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 12) {
                        card = new Card("SQ");
                        newDeck.add(card);
                    } else if (i % 13 + 1 == 13) {
                        card = new Card("SK");
                        newDeck.add(card);
                    } else {
                        card = new Card("S" + (i % 13 + 1));
                        newDeck.add(card);
                    }
            }
        }

        Collections.shuffle(newDeck);

        return newDeck;
    }


    /**
     * Draw a card from the deck
     * Return the card drawn and remove it from the deck
     *
     * @return cardDrawn: The card drawn from the deck
     */
    public Card drawCard() {

        Card cardDrawn = content.getFirst();
        content.removeFirst();
        size--;

        return cardDrawn;
    }


    /**
     * Getter for size
     *
     * @return size: The amount of cards in the deck
     */
    public int getSize() {
        return size;
    }
}
