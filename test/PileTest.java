import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PileTest{
    private Pile pile;
    private Card card1;
    private Card card2;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        pile = new Pile();

        // Initialize cards
        card1 = new Card(Suit.HEARTS, Rank.ACE);  // Ace of Hearts
        card2 = new Card(Suit.SPADES, Rank.KING); // King of Spades

        // Redirect console output to capture it for print tests
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddAndGetTopCard() {

        assertNull(pile.getTopCard()); //Check returns null for empty pile

        pile.add(card1);

        // Ensure that the top card is the one we added
        assertEquals(card1, pile.getTopCard());

        // Add another card and check if it's now the top card
        pile.add(card2);
        assertEquals(card2, pile.getTopCard());
    }

    @Test
    public void testPrintTopCard() {
        // Test printing when the pile is empty
        pile.printTopCard();
        assertEquals("", outContent.toString().trim());  // No output expected for an empty pile

        // Add a card and test printing it
        pile.add(card1);
        card1.flip();
        pile.printTopCard();
        String expected = "|\u001B[31;47m A♥\033[0m|"; //Ace of hearts
        assertEquals(expected, outContent.toString());
        outContent.reset();

        // Add another card and test printing it
        pile.add(card2);
        card2.flip();
        pile.printTopCard();
        expected = "|\u001B[30;47m K♠\033[0m|"; //King of spades
        assertEquals(expected, outContent.toString());
        outContent.reset();
    }

}