package com.company;

import java.util.LinkedList;


/**
 * Class tests
 * Meant for testing different scenarios for the game
 */
public class Tests {


    public Tests() {

    }


    /**
     * Start a bunch of games meant for testing
     * In order:
     * 22-22 first round, dealer wins (1)
     * 21-21 first round, Sam wins (2)
     * Blackjack first round for the dealer (3)
     * Blackjack first round for Sam (4)
     * Above 21 for the dealer, Sam wins (5)
     * Above 21 for Sam, dealer wins (6)
     * Sam above 17 and dealer above sam but under 22, dealer wins (7)
     * A set of 10 games with randomly generated decks (8)
     */
    public static void runTests() {
        System.out.println("Test (1):");
        test1();
        System.out.println("-------------------------");
        System.out.println("Test (2):");
        test2();
        System.out.println("-------------------------");
        System.out.println("Test (3):");
        test3();
        System.out.println("-------------------------");
        System.out.println("Test (4):");
        test4();
        System.out.println("-------------------------");
        System.out.println("Test (5):");
        test5();
        System.out.println("-------------------------");
        System.out.println("Test (6):");
        test6();
        System.out.println("-------------------------");
        System.out.println("Test (7):");
        test7();
        System.out.println("-------------------------");
        System.out.println("Test (8):");
        test8();
        System.out.println("-------------------------");
    }


    /**
     * Test 1
     * 22-22 first round, dealer wins
     */
    public static void test1() {
        LinkedList<Card> deckTest1 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest1.add(card);
        card = new Card("HA");
        deckTest1.add(card);
        card = new Card("DA");
        deckTest1.add(card);
        card = new Card("SA");
        deckTest1.add(card);
        Blackjack test1 = new Blackjack(deckTest1);
        test1.play();
    }


    /**
     * Test 2
     * 21-21 first round, Sam wins
     */
    public static void test2() {
        LinkedList<Card> deckTest2 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest2.add(card);
        card = new Card("HA");
        deckTest2.add(card);
        card = new Card("DJ");
        deckTest2.add(card);
        card = new Card("SK");
        deckTest2.add(card);
        Blackjack test2 = new Blackjack(deckTest2);
        test2.play();
    }


    /**
     * Test 3
     * 21-15 first round, dealer wins
     */
    public static void test3() {
        LinkedList<Card> deckTest3 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest3.add(card);
        card = new Card("HA");
        deckTest3.add(card);
        card = new Card("D4");
        deckTest3.add(card);
        card = new Card("SQ");
        deckTest3.add(card);
        Blackjack test3 = new Blackjack(deckTest3);
        test3.play();
    }


    /**
     * Test 4
     * 15-21 first round, Sam wins
     */
    public static void test4() {
        LinkedList<Card> deckTest4 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest4.add(card);
        card = new Card("HA");
        deckTest4.add(card);
        card = new Card("D10");
        deckTest4.add(card);
        card = new Card("S4");
        deckTest4.add(card);
        Blackjack test4 = new Blackjack(deckTest4);
        test4.play();
    }


    /**
     * Test 5
     * Above 21 for the dealer, Sam wins
     */
    public static void test5() {
        LinkedList<Card> deckTest5 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest5.add(card);
        card = new Card("HA");
        deckTest5.add(card);
        card = new Card("D9");
        deckTest5.add(card);
        card = new Card("S4");
        deckTest5.add(card);
        card = new Card("S8");
        deckTest5.add(card);
        Blackjack test5 = new Blackjack(deckTest5);
        test5.play();
    }


    /**
     * Test 6
     * Above 21 for Sam, dealer wins
     */
    public static void test6() {
        LinkedList<Card> deckTest6 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest6.add(card);
        card = new Card("HA");
        deckTest6.add(card);
        card = new Card("D5");
        deckTest6.add(card);
        card = new Card("S4");
        deckTest6.add(card);
        card = new Card("H10");
        deckTest6.add(card);
        Blackjack test6 = new Blackjack(deckTest6);
        test6.play();
    }


    /**
     * Test 7
     * Sam above 17 and dealer above sam but under 22, dealer wins
     */
    public static void test7() {
        LinkedList<Card> deckTest7 = new LinkedList<>();
        Card card = new Card("CA");
        deckTest7.add(card);
        card = new Card("HA");
        deckTest7.add(card);
        card = new Card("D5");
        deckTest7.add(card);
        card = new Card("S2");
        deckTest7.add(card);
        card = new Card("H2");
        deckTest7.add(card);
        card = new Card("C6");
        deckTest7.add(card);
        Blackjack test7 = new Blackjack(deckTest7);
        test7.play();
    }


    /**
     * Test 8
     * A set of 10 games with randomly generated decks
     */
    public static void test8() {

        String[] fakeArgs = {};

        for (int i = 0 ; i < 10 ; i++) {
            Blackjack testRandom = new Blackjack(fakeArgs);
            testRandom.play();
        }
    }
}
