package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
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

    //This method takes in an upper limit and returns a random number less than the upper limit
    private static int randomize(int max) {
        Random rand = new Random();
        return (rand.nextInt(max));
    }
}

