
public class GameBoard {
    private static int points;// Add/////////////////////
    private int movesMade; //Add///////////////////

    private static PileList lanes;  // Piles in the main playing area
    private final PileList suitPiles;  // Piles where cards are moved to complete suits
    private final Pile drawPile;  // The draw pile
    private static Pile showing;

    public GameBoard(Deck deck) {
        points = 0;
        movesMade = 0;

        suitPiles = new PileList();
        lanes = new PileList();
        drawPile = new Pile();
        showing = new Pile();


        setLanes(lanes, deck);
        setDrawPile(deck);
        setSuitPiles();
    }
    public void setLanes(PileList lanes, Deck deck) {

        for (int i = 0; i < 7; i++){ //Create 7 empty piles in tableau
            lanes.addPile(new Pile());
        }

        for (int i = 0; i < 7; i++){ //Rows
            for (int j = i; j < 7; j++){ //Columns
                dealToLane(j, deck.dealCard()); //Deal card
            }
        }
        for (int i = 0; i < 7; i++){
            Pile pile = lanes.getPile(i);
            Card card = pile.getTopCard();
            card.flip();
        }
    }
    public void dealToLane(int index, Card card){
        Pile pile = lanes.getPile(index);
        pile.add(card);
    }
    public void setDrawPile(Deck deck) {
        for (int i = 0; i < 24; i++){
            drawPile.add(deck.dealCard());
            Card card = drawPile.getTopCard();
            card.flip();
        }
    }
    public void setSuitPiles() {
        for (int i = 0; i < 4; i++){ //Create 4 empty suit piles
            suitPiles.addPile(new Pile());
        }
    }

    public void printTopLine(){
        System.out.println(" HEARTS   DIAMONDS   SPADES    CLUBS        PILE");
        for (int i = 0; i  < 4; i++){
            Pile pile = suitPiles.getPile(i);
            if (pile.size() < 1){
                switch(i){
                    case 0: System.out.print(" |" + Card.RED + "\u2665\u2665\u2665" + Card.RESET + "|    "); break;
                    case 1: System.out.print(" |" + Card.RED + "\u2666\u2666\u2666" + Card.RESET + "|    "); break;
                    case 2: System.out.print(" |" + Card.BLACK + "\u2660\u2660\u2660" + Card.RESET + "|    "); break;
                    case 3: System.out.print(" |" + Card.BLACK + "\u2663\u2663\u2663" + Card.RESET + "|    "); break;
                }
            }
            else{
                System.out.print(" ");
                pile.printTopCard();
                System.out.print( "    ");
            }
        }
        if (showing.size() < 1){
            System.out.print("|   |");
        }
        else{
            showing.printTopCard();
        }
        if(drawPile.size() < 1){
            System.out.print("  |   |");
        }
        else{
            System.out.print("  |XXX|");
        }
        System.out.println();
        System.out.println();
    }

    public void printLanes(){
        for (int i = 0; i  < 7; i++){
            System.out.print("LANE" + (i+1) + " ");
        }
        System.out.println();
        int iterations = getLargestPileSize();
        for (int i = 0; i < iterations; i++){
            for (int j = 0; j < 7; j++){
                Pile pile = lanes.getPile(j);
                if(pile.size() > i){
                    Card card = pile.get(i);
                    card.printCard();
                    System.out.print(" ");
                }
                else{
                    System.out.print("      ");
                };
            }
            System.out.println();
        }
        System.out.println();
    }
    public void prompt(){
        printPoints();
        printMoves();
        printTopLine();
        printLanes();
        System.out.println("Please enter command");
    }

    public int getLargestPileSize() {
        int largestSize = 0;

        // Iterate through each pile in the lanes (tableau)
        for (Pile pile : lanes.getPiles()) {
            int pileSize = pile.size(); // Assuming Pile has a size() method to get the number of cards
            if (pileSize > largestSize) {
                largestSize = pileSize; // Update largestSize if the current pile is larger
            }
        }

        return largestSize; // Return the largest pile size
    }

    public void Draw(){
        if (drawPile.size() < 1) {
            for (int i = (showing.size() - 1); i > -1; i--){
                Card card = showing.get(i);
                drawPile.add(card);
            }
            showing.clear();
            decreaseMove(); //Resetting pile doesn't count as move
        }
        else{
            Card drawnCard = drawPile.getTopCard();
            drawPile.removeTop();
            showing.add(drawnCard);
        }
    }
    public static Pile getShowing(){
        return showing;
    }
    public static Pile getLane(int lane){
        return lanes.getPile(lane);
    }

    public boolean checkWin(){
        for(int i = 0; i < 4; i++) {//Check king is on top of all piles
            Pile pile = suitPiles.getPile(i);
            if (pile.size() < 1){
                return false;
            }
            Card card = pile.getTopCard();
            if(card.getRank() != 13){
                return false;
            }
        }
        printWin();
        return true;
    }

    public void printWin(){
        System.out.println("Congratulations you won");
        printPoints();
    }
    public void printQuit(){
        System.out.println("Quitting game");
        printPoints();
        printMoves();
    }
    public void printError(String message){
        System.out.println(message);
    }
    public PileList getLanes(){
        return lanes;
    }
    public PileList getSuitPiles(){
        return suitPiles;
    }

    public void addPoints(int p){
        points += p;
    }
    public void addMove(){
        movesMade++;
    }
    public void decreaseMove(){
        movesMade--;
    }

    public void printPoints(){
        System.out.println("Points scored: " + points);
    }
    public void printMoves(){
        System.out.println("Moves made: " + movesMade);
    }

}


