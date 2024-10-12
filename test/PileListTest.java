import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PileListTest{
    private PileList pileList;
    private Pile pile1;
    private Pile pile2;

    @Before
    public void setup(){
        // Set up a new PileList before each test
        pileList = new PileList();

        // Initialize some Pile objects
        pile1 = new Pile();  // Empty Pile
        pile2 = new Pile();  // Another empty Pile
    }

    @Test
    public void testAddPile() {
        pileList.addPile(pile1);

        // Ensure the pile is added and the list size is updated
        assertEquals(1, pileList.size());
        assertEquals(pile1, pileList.getPile(0));
    }

    @Test
    public void testGetPile() {
        pileList.addPile(pile1);
        pileList.addPile(pile2);

        // Ensure the piles are correctly retrieved by index
        assertEquals(pile1, pileList.getPile(0));
        assertEquals(pile2, pileList.getPile(1));

        // Test out-of-bounds index
        assertNull(pileList.getPile(2));
    }

    @Test
    public void testGetPiles() {
        // Add multiple piles to the list
        pileList.addPile(pile1);
        pileList.addPile(pile2);

        // Ensure the LinkedList is returned and contains the correct piles
        assertEquals(2, pileList.getPiles().size());
        assertTrue(pileList.getPiles().contains(pile1));
        assertTrue(pileList.getPiles().contains(pile2));
    }

    @Test
    public void testEmptyPileList() {
        // Ensure the pile list is empty initially
        assertEquals(0, pileList.size());

        // Ensure that getting a pile from an empty list returns null
        assertNull(pileList.getPile(0));
    }
}