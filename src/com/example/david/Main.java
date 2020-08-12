package com.example.david;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean canDrop;
        Player player = new Player(100);
        Deck.createDeck();
        Deck.shuffle();

        while(true) {

            placeBet(player);
            drawCards(player, 5);
            player.printHand();
            dropCards(player);
            player.printHand();

            // validate the hand

            clearCards(player);
        }

    }

    public static void placeBet(Player player) {
        while(true) {
            System.out.println("place your bet(Credit " + player.getMoney() + ")");
            int bet = scanner.nextInt();
            scanner.nextLine();

            if(bet > player.getMoney() || bet < 1) {
                System.out.println("Wrong amount");
            } else {
                break;
            }
        }
    }

    public static void drawCards(Player player, int amount) {

        for(int i = 0 ; i < amount ; i++) {
            player.getHand().add(Deck.getDeck().get(0)); //player draw a card from the top of the deck
            Deck.getDeck().remove(0);
        }
    }

    public static void dropCards(Player player) {
        int amountToDrop;
        while(true) {
            System.out.println("input the cards you want to drop(eg: 1 2 5) or 0 to keep all of them.");
            String stringInput = scanner.nextLine();
            List<String> input = Arrays.asList(stringInput.split(" "));

            if(input.size() > 5 || (input.size() > 1 && input.contains("0"))) {
                System.out.println("Wrong input");

            } else if(input.get(0).equals("0")) {
                amountToDrop = 0;
                break;
            } else {
                amountToDrop = input.size();

                for(String cardStringIndex : input) {
                    Deck.getDeck().add(player.getHand().get(Integer.parseInt(cardStringIndex)-1)); //add the card back into the package at the bottom
                    player.getHand().remove(Integer.parseInt(cardStringIndex)-1); //remove it from player`s hand
                    player.getHand().add(Integer.parseInt(cardStringIndex)-1, Deck.getDeck().get(0));
                    Deck.getDeck().remove(0);
                }
                break;
            }
        }

    }

    public static void clearCards(Player player) {
        for(int i = 0 ; i < 5 ; i++) {
            Deck.getDeck().add(player.getHand().get(0));
            player.getHand().remove(0);
        }
    }
}
