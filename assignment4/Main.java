/**
 * Main for testing Card and Deck of Cards classes
 */

package assignment4_000909883;

import java.util.Scanner;

public class Main {
    /**
     * A method to test the DeckOfCards object
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of suits:");
        int suits = sc.nextInt();
        System.out.println("Enter number of ranks:");
        int ranks = sc.nextInt();
        System.out.println("");
        DeckOfCards doc = new DeckOfCards(ranks,suits);
        for (int i = 0; i < doc.cards.length; i++ ) {
            System.out.print(doc.cards[i] + " ");  
        }
        System.out.println("\n");
        // main menu
        while (true) {
            System.out.println(doc);
            System.out.println("1 = Shuffle, 2 = Deal 1 hand, 3 = Deal 100,000 times, 4=quit: ");
            int action = sc.nextInt();
            System.out.println("");
            if (action == 1) {
                // shuffle
                doc.shuffle();
            }
            if (action == 2) {
                // deals entered number of cards
                System.out.println("How many cards: ");
                int numCards = sc.nextInt();
                Card[] hand = doc.deal(numCards);
                for (int i = 0; i < numCards; i++) {
                    System.out.print(hand[i] + " ");
                }
                System.out.println("\n");
                
            }
            if (action == 3) {
                // histogram
                System.out.println("How many cards: ");
                int numCards = sc.nextInt();
                int[] histogram = new int[numCards*suits*ranks];

                for (int i = 0; i < 100000; i++) {
                    int sum = 0;
                    doc.shuffle();
                    Card[] hand = doc.deal(numCards);
                    for (int j = 0; j < numCards; j++) {
                        sum += hand[j].getValue();
                    }
                    histogram[sum]++;
                    
                }

                for (int i = 2; i < numCards*suits*ranks; i++) {
                    if (histogram[i] > 0) {
                        System.out.println(i + ": " + histogram[i] + " " + "*".repeat(histogram[i]/1000));
                    }
                }
                System.out.println("\n");
            }
            if (action == 4) {
                // exit
                System.out.println("Bye");
                break;
            }
        }
    }
}
