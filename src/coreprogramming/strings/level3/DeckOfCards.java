package coreprogramming.strings.level3;

import java.util.Scanner;

public class DeckOfCards {
    static String[] initializeDeck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {

        for (int i = 0; i < deck.length; i++) {
            int r = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    static String[][] distributeCards(String[] deck, int players, int cards) {

        if (players * cards > deck.length)
            return null;

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                result[i][j] = deck[index++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter players and cards per player: ");
        int players = sc.nextInt();
        int cards = sc.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        String[][] result = distributeCards(deck, players, cards);

        for (int i = 0; i < result.length; i++) {
            System.out.println("\nPlayer " + (i + 1));
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}

