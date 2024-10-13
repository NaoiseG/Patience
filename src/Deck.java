import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private final LinkedList<Card> deck;

    public Deck(){
        deck = new LinkedList<>(); // List of cards
        setDeck();
        shuffleDeck();
    }

    private void setDeck() {
        for (Suit suit : Suit.values()) { // 52 cards
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.removeLast(); // Access the top card

        } else {
            return null; // Return null if the deck is empty
        }
    }

    public int size(){
    return deck.size();
    }
}
