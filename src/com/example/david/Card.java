package com.example.david;

public class Card {
    private String number;
    private String symbol;

    public Card(String number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public void printCard() {
        System.out.println(this.number + " of " + this.symbol + " ");
    }

    public String getNumber() {
        return number;
    }

    public String getSymbol() {
        return symbol;
    }
}
