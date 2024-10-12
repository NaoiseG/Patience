import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

class StringCardCollection extends CardCollection<String> { //Subclass with strings for testing
}


public class CardCollectionTest {

    private CardCollection<String> cardCollection;

    @Before
    public void setup(){
        cardCollection = new StringCardCollection();
    }

    @Test
    public void testAdd() { // Check strings added correctly
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");

        assertEquals(2, cardCollection.size()); // Verify the size after adding

        assertEquals("Card 1", cardCollection.get(0)); // Verify that items were added correctly
        assertEquals("Card 2", cardCollection.get(1));
    }

    @Test
    public void testRemoveTop() {
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");

        cardCollection.removeTop(); // Remove the top (last) card
        assertEquals(1, cardCollection.size()); // Check size
        assertEquals("Card 1", cardCollection.getTop()); // Verify the remaining card is "Card 1"

        cardCollection.removeTop(); // Remove the last remaining card
        assertEquals(0, cardCollection.size());
        assertNull(cardCollection.getTop()); //Check returns NULL
    }

    @Test
    public void testRemove() { // Test remove by index
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");
        cardCollection.add("Card 3");

        cardCollection.remove(1); // Remove the second item ("Card 2")
        assertEquals(2, cardCollection.size());
        assertEquals("Card 1", cardCollection.get(0)); // Verify first card is "Card 1"
        assertEquals("Card 3", cardCollection.get(1)); // Verify second card is "Card 3"

        // Test out-of-bound index
        cardCollection.remove(5); // Should do nothing
        assertEquals(2, cardCollection.size());
    }

    @Test
    public void testClear() {
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");
        cardCollection.clear(); // Clear the collection

        assertEquals(0, cardCollection.size());  // Collection should be empty
        assertNull(cardCollection.getTop());
    }

    @Test
    public void testGet() {
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");

        assertEquals("Card 1", cardCollection.get(0));  // Test valid index
        assertEquals("Card 2", cardCollection.get(1));  // Test valid index
        assertNull(cardCollection.get(2));
    }

    @Test
    public void testGetTop() {
        cardCollection.add("Card 1");
        cardCollection.add("Card 2");

        assertEquals("Card 2", cardCollection.getTop());  // The top card should be "Card 2"
        cardCollection.removeTop();
        assertEquals("Card 1", cardCollection.getTop());  // Now the top card should be "Card 1"
        cardCollection.removeTop();
        assertNull(cardCollection.getTop());
    }

    @Test
    public void testSize() { //Test return size
        assertEquals(0, cardCollection.size());  // Initially empty

        cardCollection.add("Card 1");
        assertEquals(1, cardCollection.size());  // Size should be 1 after adding one item

        cardCollection.add("Card 2");
        assertEquals(2, cardCollection.size());  // Size should be 2 after adding another item

        cardCollection.removeTop();
        assertEquals(1, cardCollection.size());  // Size 1 again
    }
}