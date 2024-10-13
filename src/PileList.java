import java.util.LinkedList;

public class PileList extends CardCollection<Pile> { // List of piles

    public PileList() {
        super();  // Call the constructor of CardCollection
    }

    // Add a Pile to the collection
    public void addPile(Pile pile) {
        add(pile);  // Clarify adding pile
    }

    // Get a specific Pile from the collection
    public Pile getPile(int index) {
        return get(index);  // Clarify getting pile
    }

    public LinkedList<Pile> getPiles() {
        return items;  // Returns whole list
    }
}

