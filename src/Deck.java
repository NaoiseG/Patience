import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private final LinkedList<Card> deck;

    public Deck(){
        deck = new LinkedList<>();
        setDeck();
        shuffleDeck();
    }

    private void setDeck() {
        for (Suit suit : Suit.values()) {
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
            return deck.removeLast(); // Access the top card (last in the list)

        } else {
            return null; // Return null if the deck is empty
        }
    }

    public int size(){
    return deck.size();
    }
}
