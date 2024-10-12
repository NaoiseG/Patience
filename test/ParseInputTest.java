import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParseInputTest{

    private ParseInput parseInput;

    @Test
    public void testTwoCharacterInput() {
        parseInput = new ParseInput("ps");

        // Check that it defaults to 1 move
        assertEquals(1, parseInput.moves);

        assertEquals('p', parseInput.from);
        assertEquals('s', parseInput.to);
    }

    @Test
    public void testThreeCharacterInput() {
        parseInput = new ParseInput("35d");

        // Check that it parses 3 moves correctly
        assertEquals(3, parseInput.moves);

        assertEquals('5', parseInput.from);
        assertEquals('d', parseInput.to);
    }

    @Test
    public void testFourCharacterInput() {
        parseInput = new ParseInput("1073");

        // Check that it parses 10 moves correctly
        assertEquals(10, parseInput.moves);

        assertEquals('7', parseInput.from);
        assertEquals('3', parseInput.to);
    }

    @Test
    public void testInvalidInput(){
        parseInput = new ParseInput("abcde");

        assertEquals(100, parseInput.moves); // Check moves is set to 100 (Invalid number)

        assertEquals('X', parseInput.from); // Check source and destination piles set to invalid value
        assertEquals('X', parseInput.to);
    }

    @Test
    public void testGetSuitValue() {
        assertEquals(1, ParseInput.getSuitValue('h'));  // Hearts
        assertEquals(2, ParseInput.getSuitValue('d'));  // Diamonds
        assertEquals(3, ParseInput.getSuitValue('s'));  // Spades
        assertEquals(4, ParseInput.getSuitValue('c'));  // Clubs

        // Invalid inputs
        assertEquals(0, ParseInput.getSuitValue('x'));  // Invalid suit character
        assertEquals(0, ParseInput.getSuitValue('z'));
    }

    @Test
    public void testEmptyInput(){
        parseInput = new ParseInput("");

        assertEquals(100, parseInput.moves); // Sets values to invalid values

        assertEquals('X', parseInput.from);
        assertEquals('X', parseInput.to);
    }
}