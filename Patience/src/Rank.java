public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rank fromValue(int value) {
        for (Rank rank : Rank.values()) {
            if (rank.getValue() == value) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Invalid rank value: " + value);
    }
}
