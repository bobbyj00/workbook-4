package com.pluralsight;


class Card {
    String suit;
    String rank;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    int getValue() {
        if (rank.equals("Ace")) return 11;
        if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) return 10;
        return Integer.parseInt(rank);
    }

    public String toString() {
        return rank + " of " + suit;
    }
}