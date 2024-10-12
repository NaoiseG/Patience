import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveHandlerTest{

    private MoveHandler moveHandler;
    private GameBoard gameBoard;
    private Pile lanePile;
    private Pile dealerPile;

    @Before
    public void setUp() {
        Deck deck = new Deck();
        gameBoard = new GameBoard(deck);
        lanePile = new Pile();
        dealerPile = new Pile();

        moveHandler = new MoveHandler(gameBoard);
    }

    @Test
    public void testCheckLaneMove_Valid() {
        // Add a King of Spades to the lane (valid move for Queen of Hearts)
        Card kingOfSpades = new Card(Suit.SPADES, Rank.KING);
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        kingOfSpades.flip();
        queenOfHearts.flip();

        lanePile.add(kingOfSpades);

        gameBoard.getLanes().addPile(lanePile); // Add mock lane (lane 8)

        // Check lane move with Queen of Hearts
        assertTrue(moveHandler.checkLaneMove(7, queenOfHearts));
    }

    @Test
    public void testCheckLaneMove_Invalid() {
        Card laneCard = new Card(Suit.SPADES, Rank.JACK);
        Card queenOfSpades = new Card(Suit.HEARTS, Rank.QUEEN);
        lanePile.add(laneCard);

        gameBoard.getLanes().addPile(lanePile);

        // Try to put Queen on Jack
        assertFalse(moveHandler.checkLaneMove(7, queenOfSpades));
    }

    @Test
    public void testCheckSuitMove_Valid() {
        // Add an Ace of Hearts to the suit pile (valid move for Two of Hearts)
        Card suitCard = new Card(Suit.HEARTS, Rank.ACE);
        gameBoard.getSuitPiles().getPile(0).add(suitCard);

        Card twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);

        // Check suit move with Two of Hearts
        assertTrue(moveHandler.checkSuitMove(1, twoOfHearts));
    }

    @Test
    public void testCheckSuitMove_Invalid() {
        Card suitCard = new Card(Suit.HEARTS, Rank.ACE);
        gameBoard.getSuitPiles().getPile(0).add(suitCard);

        Card threeOfHearts = new Card(Suit.HEARTS, Rank.THREE);

        // Check suit move with three of Hearts
        assertFalse(moveHandler.checkSuitMove(1, threeOfHearts));
    }

    @Test
    public void testAddToLane() {
        // Add King of Spades to the lane
        Card kingOfSpades = new Card(Suit.SPADES, Rank.KING);
        Card queenOfSpades = new Card(Suit.HEARTS, Rank.QUEEN);
        kingOfSpades.flip(); //Ensure king is showing
        queenOfSpades.flip();

        lanePile.add(kingOfSpades);
        gameBoard.getLanes().addPile(lanePile); //Extra lane pile (Lane 8)

        // Add Queen of Hearts to the dealer pile
        dealerPile.add(queenOfSpades);

        // Perform a valid move
        moveHandler.addToLane(7, 1, dealerPile);

        // Check if Queen of Hearts was added to the lane
        assertEquals(queenOfSpades, lanePile.getTopCard());
        // Check if Queen of Hearts was removed from the dealer pile
        assertEquals(0, dealerPile.size());
    }

    @Test
    public void testAddToSuitPile() {
        // Add Ace of Hearts to the suit pile
        Card aceOfHearts = new Card(Suit.HEARTS, Rank.ACE);
        gameBoard.getSuitPiles().getPile(0).add(aceOfHearts);

        // Add Two of Hearts to the dealer pile
        Card twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
        dealerPile.add(twoOfHearts);

        // Perform a valid move to the suit pile
        boolean result = moveHandler.addToSuitPile(1, 1, dealerPile);

        // Check if the move was successful
        assertTrue(result);
        // Check if Two of Hearts was added to the suit pile
        assertEquals(twoOfHearts, gameBoard.getSuitPiles().getPile(0).getTopCard());
        // Check if Two of Hearts was removed from the dealer pile
        assertEquals(0, dealerPile.size());
    }
}