package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGameWithHitStay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        Deck deck = new Deck();

        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");
            players.add(new Player(scanner.nextLine()));
        }

        // Deal 2 initial cards
        for (Player player : players) {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }

        System.out.println("\n--- Starting Hands ---");
        for (Player player : players) {
            player.showHand();
        }

        // Turn loop: each player decides to Hit or Stay
        for (Player player : players) {
            while (true) {
                player.showHand();
                if (player.isBusted()) {
                    System.out.println(player.name + " busted!");
                    break;
                }

                System.out.print(player.name + ", do you want to Hit or Stay? (H/S): ");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.equals("H")) {
                    player.addCard(deck.dealCard());
                } else if (choice.equals("S")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter H or S.");
                }
            }
        }

        // Determine winner
        Player winner = null;
        int bestScore = 0;

        for (Player player : players) {
            int score = player.getScore();
            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        // Final results
        System.out.println("\n--- Final Hands ---");
        for (Player player : players) {
            player.showHand();
        }

        if (winner != null) {
            System.out.println("\n Winner: " + winner.name + " with " + bestScore + " points!");
        } else {
            System.out.println("\nNo winner. Everyone busted.");
        }
    }
}
