package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    List<Card> cards = new ArrayList<>();

    Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    void shuffle() {
        Collections.shuffle(cards);
    }

    Card dealCard() {
        return cards.remove(0);
    }
}