/**
 * Card class, keeps track of card suit, rank and value
 * @author Jack White
 */

package assignment4_000909883;

public class Card {
    /** rank and suit of card */
    private int rank, suit;
    /** value of card (rank*suit) */
    private int value;

    /**
     * Constructor for card, takes cards rank and suit
     * 
     * @param rank rank of the card (associated number)
     * @param suit suit of the card (diamond, clover, etc.)
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = rank*suit;
    }

    /**
     * Gets value (rank*suit)
     * 
     * @return value which is rank*suit
     */
    public int getValue() {
        return value;
    }

    /** 
     * toString for card class
     * 
     * @return Card suit number and rank number
     */
    public String toString() {
        return "Card S" + suit + "R" + rank;
    }
}