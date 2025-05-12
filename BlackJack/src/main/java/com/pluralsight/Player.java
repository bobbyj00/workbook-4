package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

class Player {
    String name;
    List<Card> hand = new ArrayList<>();

    Player(String name) {
        this.name = name;
    }

    void addCard(Card card) {
        hand.add(card);
    }

    int getScore() {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.rank.equals("Ace")) aceCount++;
        }
        //change ace from 11 to 1 if needed
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }

    void showHand() {
        System.out.println(name + "'s hand: " + hand + " | Score: " + getScore());
    }

    boolean isBusted() {
        return getScore() > 21;
    }
}
