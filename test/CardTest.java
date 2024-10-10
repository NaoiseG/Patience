import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CardTest {

    private Card cardRed;
    private Card cardBlack;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        // Hearts (Red) with Rank of 1 (Ace)
        cardRed = new Card(Suit.HEARTS, Rank.ACE);
        // Spades (Black) with Rank of 13 (King)
        cardBlack = new Card(Suit.SPADES, Rank.KING);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConstructor() {
        // Test red card
        assertEquals(Suit.HEARTS, cardRed.getSuit());
        assertEquals(1, cardRed.getRank());
        assertTrue(cardRed.isRed());

        // Test black card
        assertEquals(Suit.SPADES, cardBlack.getSuit());
        assertEquals(13, cardBlack.getRank());
        assertFalse(cardBlack.isRed());
    }

    @Test
    public void testIsFaceDownByDefault() {
        // Test that cards are face down by default
        assertTrue(cardRed.isFaceDown());
        assertTrue(cardBlack.isFaceDown());
    }

    @Test
    public void testFlipCard() {
        // Flip card and check face up status
        cardRed.flip();
        assertFalse(cardRed.isFaceDown());  // Should now be face up

        cardBlack.flip();
        assertFalse(cardBlack.isFaceDown());  // Should now be face up

        // Flip again to verify toggle functionality
        cardRed.flip();
        assertTrue(cardRed.isFaceDown());  // Should be face down again

        cardBlack.flip();
        assertTrue(cardBlack.isFaceDown());  // Should be face down again
    }

    @Test
    public void testGetRank() {
        assertEquals(1, cardRed.getRank()); // Rank should be Ace (1)
        assertEquals(13, cardBlack.getRank()); // Rank should be King (13)
    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.HEARTS, cardRed.getSuit()); // Should be Hearts
        assertEquals(Suit.SPADES, cardBlack.getSuit()); // Should be Spades
    }

    @Test
    public void testIsRed() {
        assertTrue(cardRed.isRed());  // Hearts should be red
        assertFalse(cardBlack.isRed()); // Spades should not be red
    }

    @Test
    public void testPrintCardFaceDown(){
        cardRed.printCard();
        String expected = "|XXX\033[0m|";
        assertEquals(expected, outContent.toString());

        outContent.reset();

        cardBlack.printCard();
        expected = "|XXX\u001B[0m|";
        assertEquals(expected, outContent.toString());

        outContent.reset();
    }

    @Test
    public void testPrintCardFaceUp(){
        cardRed.flip();
        cardBlack.flip();

        cardRed.printCard();
        String expected = "|\u001B[47m A\u001B[31;47m♥\033[0m|";
        assertEquals(expected, outContent.toString());
        outContent.reset();

        cardBlack.printCard();
        expected = "|\u001B[47m K\u001B[30;47m♠\033[0m|";
        assertEquals(expected, outContent.toString());
        outContent.reset();
    }
}
