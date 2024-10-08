public class Pile extends CardCollection<Card> {

    public Pile() {
        super();  // Call the constructor of CardCollection
    }


    // Additional methods unique to Pile can still be added if necessary
    public Card getTopCard() {
        return getTop();  // Use the inherited getTop() method
    }

    public void printTopCard() {
        if (!items.isEmpty()) {
            Card card = getTop();  // Get the top card from the pile
            card.printCard();  // Call the print method of Card
        }
    }
}
