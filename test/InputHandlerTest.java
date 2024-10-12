import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class InputHandlerTest{

    private InputHandler inputHandler;

    @Before
    public void setUp() {
        inputHandler = new InputHandler(new Scanner(System.in));
    }

    @Test
    public void testGetInput() {
        Scanner scanner = new Scanner(" Hello World \n"); // Mock input
        InputHandler inputHandlerTest = new InputHandler(scanner);

        // Test that input is trimmed
        assertEquals("Hello World", inputHandlerTest.getInput());
    }

    @Test
    public void testIsQuitCommand() {
        assertTrue(inputHandler.isQuitCommand("Q"));    // Should return true
        assertTrue(inputHandler.isQuitCommand("q"));    // Case insensitive
        assertFalse(inputHandler.isQuitCommand("X"));
    }

    @Test
    public void testIsEnterCommand() {
        assertTrue(inputHandler.isQuitCommand("Q"));    // Should return true
        assertTrue(inputHandler.isQuitCommand("q"));    // Case insensitive
        assertFalse(inputHandler.isQuitCommand("X"));
    }

    @Test
    public void testIsDrawCommand() {
        assertTrue(inputHandler.isDrawCommand("D"));    // Should return true
        assertTrue(inputHandler.isDrawCommand("d"));    // Case insensitive
        assertFalse(inputHandler.isDrawCommand("X"));
    }

    @Test
    public void testIsValidLength() {
        assertTrue(inputHandler.isValidLength("ab"));    // Valid length (2)
        assertTrue(inputHandler.isValidLength("abc"));   // Valid length (3)
        assertTrue(inputHandler.isValidLength("abcd"));  // Valid length (4)
        assertFalse(inputHandler.isValidLength("a"));    // Invalid length (1)
        assertFalse(inputHandler.isValidLength("abcde")); // Invalid length (>4)
    }

    @Test
    public void testValidNumMoves() { //Moves will never be 0
        assertTrue(inputHandler.validNumMoves(1));   // Valid move (1)
        assertTrue(inputHandler.validNumMoves(13));  // Valid move (13)
        assertFalse(inputHandler.validNumMoves(14));
    }
}