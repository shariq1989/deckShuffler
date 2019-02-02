package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class prints to console a list of cards from a shuffled 52 card deck
 */
public class DeckShufflerApp {
    public static void main(String[] args) {
        shuffleDeck();
    }

    /**
     * Prints strings representing a shuffled 52 card deck
     */
    private static void shuffleDeck() {
        String[] cardRanks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        List<CardModel> cardsToBeProcessed = new ArrayList<>();
        List<CardModel> shuffledDeck = new ArrayList<>();

        // Build a sorted 52 card deck
        for (String suit : cardSuits) {
            for (String rank : cardRanks) {
                CardModel newCard = new CardModel();
                newCard.setRank(rank);
                newCard.setSuit(suit);
                cardsToBeProcessed.add(newCard);
            }
        }

        // While there are still cards to be processed
        while (cardsToBeProcessed.size() != 0) {
            // Add a random card from the sorted deck to the new deck
            int randomCard = randomize(cardsToBeProcessed.size());
            shuffledDeck.add(cardsToBeProcessed.get(randomCard));
            // Remove the card from the sorted deck
            cardsToBeProcessed.remove(randomCard);
        }
        // Print the shuffled deck
        for (CardModel card : shuffledDeck) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
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

