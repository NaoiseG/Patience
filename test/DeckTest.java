import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest{

    private Deck deck1;
    private Deck deck2;

    @Before
    public void setUp(){
        deck1 = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void testCheckDeckSize(){ //Ensure 52 cards
        assertEquals(52, deck1.size());
        assertEquals(52, deck2.size());
    }

    @Test
    public void testShuffleAndDeal(){
        Card card1 = deck1.dealCard();
        Card card2 = deck2.dealCard();
        assertNotEquals(card1, card2); //Different card at the top
    }

}