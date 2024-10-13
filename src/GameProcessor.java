public class GameProcessor {
    InputHandler inputHandler;
    MoveHandler moveHandler;
    GameBoard gameBoard;

    public GameProcessor(GameBoard gameBoard, InputHandler inputHandler, MoveHandler moveHandler) {
        this.gameBoard = gameBoard;
        this.inputHandler = inputHandler;
        this.moveHandler = moveHandler;
    }

    public void processInput(String input) { // Parses input and makes corresponding move
        ParseInput parseInput = new ParseInput(input);
        executeMove(parseInput, gameBoard);
    }

    public void executeMove(ParseInput parseInput, GameBoard gameBoard) {
        char from = parseInput.from;
        int moves = parseInput.moves;

        if(!inputHandler.validNumMoves(moves)){
            gameBoard.printError("ERROR: " + moves + " NUMBER OF MOVES NOT VALID");// Check valid number of moves
            return;
        }

        switch (from) { // Check moving from pile or lane
            case 'P', 'p':
                pileMove(parseInput, gameBoard);
                break;
            case '1', '2', '3', '4', '5', '6', '7':
                laneMove(parseInput, gameBoard);
                break;

            default:
                gameBoard.printError("ERROR: STARTING PILE \"" + from + "\" DOESN'T EXIST"); break;
        }
    }

    public void pileMove(ParseInput parseInput, GameBoard gameBoard) { // Move from pile
        char to = Character.toLowerCase(parseInput.to);
        int moves = parseInput.moves;

        if(parseInput.input.length() > 2){
            gameBoard.printError("CAN ONLY TAKE ONE CARD FROM DRAW PILE");
        }

        switch(to){
            case '1', '2', '3', '4', '5', '6', '7': int lane = Character.getNumericValue(to);
                //Moved from pile to lane
                moveHandler.addToLane(lane - 1, 1, gameBoard.getShowing()); break;
            case 'h', 'd', 's', 'c': int suit = ParseInput.getSuitValue(to);
                if(moveHandler.addToSuitPile(moves, suit, gameBoard.getShowing())){
                    gameBoard.addPoints(10); //Add points for correct move
                };//Pile to Hearts
                break;
            default:
                gameBoard.printError("ERROR: DESTINATION PILE \"" + to + "\" DOESN'T EXIST"); break;
            //Add to suits
        }
    }

    public void laneMove(ParseInput parseInput, GameBoard gameBoard){ // Move from lane
        char to = Character.toLowerCase(parseInput.to);
        int dealingLane = Character.getNumericValue(parseInput.from);
        int moves = parseInput.moves;

        switch(to){
            case '1', '2', '3', '4', '5', '6', '7': int lane = Character.getNumericValue(to);
                moveHandler.addToLane(lane - 1, moves, gameBoard.getLane(dealingLane - 1));
                break;
            case 'h', 'd', 's', 'c': int suit = ParseInput.getSuitValue(to);
                if(moveHandler.addToSuitPile(moves, suit, gameBoard.getLane(dealingLane - 1))){
                gameBoard.addPoints(20);
            }; break;
            default: gameBoard.printError("ERROR: DESTINATION PILE \"" + to + "\" DOESN'T EXIST"); break;
        }
    }

}
