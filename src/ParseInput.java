public class ParseInput { // Parses input to determine source and destination piles and number of moves
    String input;
    int moves;
    char from;
    char to;

    public ParseInput(String input) {
        this.input = input;
        switch(input.length()){
            case 2: this.moves = 1; this.from = input.charAt(0); this.to = input.charAt(1); break;
            case 3: this.moves = Character.getNumericValue(input.charAt(0)); this.from = input.charAt(1); this.to = input.charAt(2); break;
            case 4: this.moves = (Character.getNumericValue(input.charAt(0)))*10 + Character.getNumericValue(input.charAt(1)); this.from = input.charAt(2); this.to = input.charAt(3); break;
            default: this.moves = 100; this.from = 'X'; this.to = 'X'; break; //Will be classed as invalid input
        }
    }
    public static int getSuitValue(char suitChar) {
        return switch (suitChar) {
            case 'h' -> 1;  // Hearts
            case 'd' -> 2;  // Diamonds
            case 's' -> 3;  // Spades
            case 'c' -> 4;  // Clubs
            default -> 0; // Move will be invalid
        };
    }
}
