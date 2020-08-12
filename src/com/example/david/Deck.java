package com.example.david;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private static List<Card> deck = new ArrayList<>();

    public static void createDeck() {
        List<String> symbols = Arrays.asList("Cloud", "Diamond", "Black Heart", "Red Heart");
        List<String> numbers = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

        for(String symbol : symbols) {
            for(String number : numbers) {
                Card card = new Card(number, symbol);
                deck.add(card);
            }
        }
    }

    private static void swap(int i, int j) {
        Card tmp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, tmp);
    }

    public static void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomPosition = (int) (Math.random() * 52);
            swap(i, randomPosition);
        }
    }

    public static List<Card> getDeck() {
        return deck;
    }


}
