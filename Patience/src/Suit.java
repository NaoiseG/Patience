public enum Suit {
    HEARTS(1), DIAMONDS(2), SPADES(3), CLUBS(4);

    private final int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit fromChar(char c) {
        return switch (Character.toLowerCase(c)) {
            case 'h' -> HEARTS;
            case 'd' -> DIAMONDS;
            case 's' -> SPADES;
            case 'c' -> CLUBS;
            default -> throw new IllegalArgumentException("Invalid suit: " + c);
        };
    }
}
