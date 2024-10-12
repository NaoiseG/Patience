import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameBoardTest{

    private GameBoard gameBoard;

    @Before
    public void setUp() {
        // Initialize a deck and game board before each test
        Deck deck = new Deck();
        gameBoard = new GameBoard(deck);
    }

    @Test
    public void testInitialization() {
        // Check that the lanes are initialized with 7 piles
        assertEquals(7, gameBoard.getLanes().size());

        // Check that the suit piles are initialized with 4 piles
        assertEquals(4, gameBoard.getSuitPiles().size());
    }

    @Test
    public void testSetLanes() { // Check lanes have correct number of cards
        for (int i = 0; i < 7; i++){
            assertEquals(i+1, gameBoard.getLane(i).size());
        }
    }

    @Test
    public void testSetDrawPile() {
        assertEquals(24, gameBoard.getDrawPile().size()); // Draw pile has 24 cards
        assertEquals(0, gameBoard.getShowing().size()); // Showing starts empty
    }

    @Test
    public void testGetLargestPileSize() {
        assertEquals(7, gameBoard.getLargestPileSize()); // Largest lane has 7 cards
        Card card = new Card(Suit.HEARTS, Rank.ACE);
        gameBoard.dealToLane(6, card); // Add card to the largest lane
        assertEquals(8, gameBoard.getLargestPileSize()); //Should now have 8
    }

    @Test
    public void testDraw() {
        gameBoard.Draw();
        assertEquals(23, gameBoard.getDrawPile().size()); // Card moves from draw [pile to showing
        assertEquals(1, gameBoard.getShowing().size());
    }

    @Test
    public void testResetDrawPileWhenEmpty() {
        // Test resetting the draw pile when it's empty
        for (int i = 0; i < 24; i++) { // Draw all 24 cards
            gameBoard.Draw();
        }
        assertEquals(0, gameBoard.getDrawPile().size());
        assertEquals(24, gameBoard.getShowing().size());

        // Reset the draw pile
        gameBoard.Draw();

        // Ensure the draw pile is reset
        assertEquals(24, gameBoard.getDrawPile().size());
        assertEquals(0, gameBoard.getShowing().size());
    }

    @Test
    public void testCheckWin() {
        assertFalse(gameBoard.checkWin());

        Card card1 = new Card(Suit.HEARTS, Rank.KING);
        Card card2 = new Card(Suit.DIAMONDS, Rank.KING);
        Card card3 = new Card(Suit.SPADES, Rank.KING);
        Card card4 = new Card(Suit.HEARTS, Rank.KING);

        gameBoard.getSuitPiles().getPile(0).add(card1); //Add a king to all suit piles
        gameBoard.getSuitPiles().getPile(1).add(card2);
        gameBoard.getSuitPiles().getPile(2).add(card3);
        gameBoard.getSuitPiles().getPile(3).add(card4);

        assertTrue(gameBoard.checkWin());
    }

    @Test
    public void testGetLanes() {
        assertEquals(7, gameBoard.getLanes().size()); //Check gets all 7 lanes

        Card card = new Card(Suit.HEARTS, Rank.KING);
        gameBoard.getLane(0).add(card);
        assertEquals(card, gameBoard.getLanes().get(0).getTopCard()); // Check retrieves card properly
    }

    @Test
    public void testGetSuitPiles() {
        assertEquals(4, gameBoard.getSuitPiles().size()); //Check gets all 4 suits

        Card card = new Card(Suit.HEARTS, Rank.ACE);
        gameBoard.getSuitPiles().get(0).add(card);
        assertEquals(card, gameBoard.getSuitPiles().get(0).getTopCard());
    }

    @Test
    public void testAddPoints() {
        assertEquals(0, gameBoard.getPoints());
        gameBoard.addPoints(10);

        // Check if points are updated correctly
        assertEquals(10, gameBoard.getPoints());
    }

    @Test
    public void testAddMove() {
        assertEquals(0, gameBoard.getMovesMade());
        gameBoard.addMove();
        gameBoard.addMove();

        // Check if moves are updated correctly
        assertEquals(2, gameBoard.getMovesMade());
    }

    @Test
    public void testDecreaseMove() {
        gameBoard.addMove();
        assertEquals(1, gameBoard.getMovesMade());
        gameBoard.decreaseMove();
        assertEquals(0, gameBoard.getMovesMade());
    }
}