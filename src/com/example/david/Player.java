package com.example.david;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private int money;

    public Player(int money) {
        this.money = money;
    }

    public void printHand() {
        for(Card card : hand) {
            card.printCard();
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Card> getHand() {
        return hand;
    }
}
