public enum Suit { // Suit of card
    HEARTS(1), DIAMONDS(2), SPADES(3), CLUBS(4);

    private final int value; // Integer value for suit

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
