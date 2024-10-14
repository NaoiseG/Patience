public class MoveHandler {
    GameBoard gameBoard;

    public MoveHandler(GameBoard gameBoard) { // Checks and makes moves
        this.gameBoard = gameBoard;
    }

    public boolean checkLaneMove(int lane, Card card){ // Check move to lane is valid
        Pile pile = gameBoard.getLanes().getPile(lane);
        if (pile.size() < 1){
            return (card.getRank() == 13); // King can move to empty lane
        }
        Card laneCard = pile.getTopCard();
        int n = card.getRank();
        boolean red = card.isRed();
        int n2 = laneCard.getRank();
        boolean red2 = laneCard.isRed();
        return (n + 1) == n2 && red != red2; // Check rank is 1 below and colour is opposite
    }

    public boolean checkSuitMove(int n, Card card){ // Checks move to suit pile is valid
        int suit = card.getSuit().getValue();
        if(suit == n){ //Check correct suit
            Pile pile = gameBoard.getSuitPiles().getPile(suit - 1);
            if(pile.size() < 1){
                return card.getRank() == 1; // Ace can move to empty suit pile
            }
            Card suitCard = pile.getTopCard();
            return card.getRank() == (suitCard.getRank() + 1); // Check correct rank
        }
        return false;
    }

    public boolean addToLane(int lane, int moves, Pile dealer){ // Add card to lane
        int size = dealer.size();
        if (size < 1 || moves > size){
            gameBoard.printError("ERROR: INSUFFICIENT NUMBER OF CARDS IN DEALING PILE"); //Insufficient number of cards
            return false;
        }

        Pile pile = gameBoard.getLanes().getPile(lane);

        Card highest = dealer.get(dealer.size() - moves); // Highest card being moved
        if(highest.isFaceDown()){ // Card isn't face up (Invalid move)
            gameBoard.printError("ERROR: NOT ALL REQUESTED CARDS ARE SHOWING"); // All cards are not showing
            return false;
        }

        if (checkLaneMove(lane, highest)){ // Move all requested cards
            for(int i = 0; i < moves; i++){
                Card card = dealer.get(dealer.size() - moves + i);
                dealer.remove(dealer.size() - moves + i);
                pile.add(card);
            }
            if(dealer.size() > 0) {
                Card nextCard = dealer.getTopCard();
                if(nextCard.isFaceDown()) { // Flip next card
                    nextCard.flip();
                    gameBoard.addPoints(5); // Award points
                }
            }
            return true;
        }

        else{
            gameBoard.printError("ERROR: INVALID MOVE ENTERED"); //Insufficient number of cards
            return false;
        }
    }
    public boolean addToSuitPile(int moves, int index, Pile dealer){ // Add card to suit pile
        if(moves > 1){
            gameBoard.printError("ERROR: CAN ONLY MOVE ONE CARD TO SUITS AT A TIME");
            return false;
        }
        if (dealer.size() < 1) {
            gameBoard.printError("ERROR: INSUFFICIENT NUMBER OF CARDS IN DEALING PILE "); // Insufficient number of cards
            return false;
        }
        Pile pile = gameBoard.getSuitPiles().getPile(index - 1);
        Card card = dealer.getTopCard();
        if (checkSuitMove(index, card)){
            dealer.removeTop();
            if(dealer.size() > 0) { // Check cards in pile
                Card nextCard = dealer.getTopCard();
                if(nextCard.isFaceDown()) { // Flip next card
                    nextCard.flip();
                    gameBoard.addPoints(5); // Only add points if reveals new card
                }
            }
            pile.add(card);
            return true; // Boolean to award points
        }
        else{
            gameBoard.printError("ERROR: INVALID MOVE ENTERED"); //Insufficient number of cards
            return false;
        }
    }
}
