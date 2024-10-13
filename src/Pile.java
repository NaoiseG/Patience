public class Pile extends CardCollection<Card> { // Pile of cards

    public Pile() {
        super(); // Superclass constructor
    }
    public Card getTopCard() {
        return getTop(); // Method made to clarify it returns a card for readability
    }

    public void printTopCard() {
        if (!items.isEmpty()) {
            Card card = getTop();  // Get the top card from the pile
            card.printCard();  // Call the print method of Card
        }
    }
}
