/**
 * DeckOfCards class, contains array of cards as well as shuffle, and deal methods
 * @author Jack White
 */

package assignment4_000909883;

public class DeckOfCards {
    /** number of suits and ranks */
    private int suits, ranks;
    /** Array for card objects */
    Card[] cards;

    /**
     * Constructor for DeckOfCards, creates cards within rank and suit indexes
     * 
     * @param ranks number of ranks
     * @param suits number of suits
     */
    public DeckOfCards(int ranks, int suits) {
        this.ranks = ranks;
        this.suits = suits;
        int rankNum = 1;
        int suitNum = 1;
        cards = new Card[suits*ranks];
        for (int i = 0; i < cards.length; i++) {
            if (rankNum < ranks) {
                Card card = new Card(rankNum, suitNum);
                cards[i] = card;
                rankNum++;
            } else {
                Card card = new Card(rankNum, suitNum);
                cards[i] = card;
                rankNum = 1;
                suitNum++;
                
            }
            
        }
    }

    /**
     * 
     * Takes a number from the user and returns that many cards from DeckOfCards as the array named hand
     * 
     * @param numCards number of cards to be drawn
     * @return hand which is an array with the requested number of cards
     */
    public Card[] deal(int numCards) {
        Card[] hand = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i]; 
            }
        return hand;
    }

    /**
     * Shuffles cards by taking two random numbers, indexing them into the array and swapping the two array items.
     * 
     */
    public void shuffle() {
        int randomNumOne;
        int randomNumTwo;
        Card hold;
        for (int i = 0; i < cards.length*10; i++) {
            randomNumOne = (int)Math.round(Math.random()*(cards.length-1));
            randomNumTwo = (int)Math.round(Math.random()*(cards.length-1));
            hold = cards[randomNumOne];
            cards[randomNumOne] = cards[randomNumTwo];
            cards[randomNumTwo] = hold;
        }
    }

    
    /** 
     * toString for DeckOfCard class + finding minimum value
     * 
     * @return size of deck (suits*rank), minimum value, maximum value, and top (first) card
     */
    public String toString() {
        int i = 0;
        int min = Integer.MAX_VALUE;
        while (i < cards.length) {
            if (cards[i].getValue() < min) {
                min = cards[i].getValue();
            }
            i++;
        }
        return "Size of deck: " + suits*ranks + ", minimum: " + min + ", maximum: " + suits*ranks + ", top card: " + cards[0];
    }
}
