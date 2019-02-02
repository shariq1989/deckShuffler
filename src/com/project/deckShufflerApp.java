package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class prints to console a shuffled 52 card deck
 */
public class deckShufflerApp {
    public static void main(String[] args) {
        shuffleDeck();
    }

    /**
     * Prints an array of strings representing a shuffled 52 deck of cards.
     */
    private static void shuffleDeck() {
        String[] cardRanks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        List<String> cardsToBeProcessed = new ArrayList<>();
        List<String> shuffledDeck = new ArrayList<>();

        //Build a 52 card sorted deck
        for (String suit : cardSuits) {
            for (String rank : cardRanks) {
                cardsToBeProcessed.add(rank + " of " + suit + " ");
            }
        }

        //While there are still cards to be processed
        while (cardsToBeProcessed.size() != 0) {
            //Add a random card from the sorted deck to the new deck
            int randomCard = randomize(cardsToBeProcessed.size());
            shuffledDeck.add(cardsToBeProcessed.get(randomCard));
            //Remove the card from the sorted deck
            cardsToBeProcessed.remove(randomCard);
        }
        //Print the shuffled deck
        System.out.println(shuffledDeck);
    }

    /**
     * This method takes in an int as the upper limit and returns a random number between 0 and the upper limit
     *
     * @param max The random generated must be less than this number
     * @return An integer between 0 and max
     */
    private static int randomize(int max) {
        Random rand = new Random();
        return (rand.nextInt(max));
    }
}

