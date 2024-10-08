public class Card {
    public static final String RED = "\u001B[31;47m";  // Red
    public static final String RESET = "\033[0m";  // Reset color
    public static final String BLACK = "\u001B[30;47m";  // Blue

    final String WHITE_B = "\u001B[47m"; // White background


    private boolean faceUp;  // Whether the card is face up or down
    private final boolean red; //True if card is red

    private final Suit suit;
    private final Rank rank;

    // Constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit; //Hearts, Spades, Diamonds, Clubs
        this.rank = rank; //1 to 13

        red = suit.getValue() <= 2;

        this.faceUp = false; // Default face down
    }

    // Checks if card is face up
    public boolean isFaceDown() {
        return !faceUp;
    }

    public int getRank() {
        return rank.getValue();
    }
    public Suit getSuit() {
        return suit;
    }
    public boolean isRed() {
        return red;
    }

    // Flip the card (toggle face-up/face-down)
    public void flip() {
        faceUp = !faceUp;
    }

    public void printCard(){
        System.out.print("|");
        if(faceUp) {
            System.out.print(WHITE_B);
            switch (rank) {
                case ACE:
                    System.out.print(" A");
                    break;
                case JACK:
                    System.out.print(" J");
                    break;
                case QUEEN:
                    System.out.print(" Q");
                    break;
                case KING:
                    System.out.print(" K");
                    break;
                default:
                    System.out.printf("%2d", rank.getValue());
                    break;
            }

            switch (suit) {
                case HEARTS:
                    System.out.print(RED + "\u2665");
                    break;
                case DIAMONDS:
                    System.out.print(RED + "\u2666");
                    break;
                case SPADES:
                    System.out.print(BLACK + "\u2660");
                    break;
                case CLUBS:
                    System.out.print(BLACK + "\u2663");
                    break;
                default:
                    break;
            }
        }
        else{
            System.out.print("XXX");
        }
        System.out.print(RESET + "|");
    }

}
