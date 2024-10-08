import java.util.LinkedList;

public class PileList extends CardCollection<Pile> {

    public PileList() {
        super();  // Call the constructor of CardCollection
    }

    // Add a Pile to the collection
    public void addPile(Pile pile) {
        add(pile);  // Use the add() method from CardCollection
    }

    // Get a specific Pile from the collection
    public Pile getPile(int index) {
        return get(index);  // Use the get() method from CardCollection
    }

    // Return the list of piles (inherited from CardCollection)
    public LinkedList<Pile> getPiles() {
        return items;  // Cast to LinkedList if you need specific LinkedList behavior
    }
}

