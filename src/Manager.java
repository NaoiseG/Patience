import java.util.Scanner;

public class Manager {
    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final GameProcessor gameProcessor;

    public Manager(){
        Deck deck = new Deck(); //Initialise deck

        this.gameBoard = new GameBoard(deck);
        this.inputHandler = new InputHandler(new Scanner(System.in));
        MoveHandler moveHandler = new MoveHandler(gameBoard);
        this.gameProcessor = new GameProcessor(gameBoard, inputHandler, moveHandler);

        play(); //Start game
    }

    public void play(){
        String input;
        while (true){
            gameBoard.prompt();
            if(inputHandler.isQuitCommand(input = inputHandler.getInput())) {
                gameBoard.printQuit();
                break;
            }

            if (inputHandler.isDrawCommand(input)){ //Check for draw
                gameBoard.Draw();
                continue;
            }
            else if(!inputHandler.isValidInput(input)){ //Check less than 5 characters entered
                gameBoard.printError("ERROR: INPUT \"" + input + "\" IS NOT VALID");
            }
            gameProcessor.processInput(input);

            if(gameBoard.checkWin())
                break;
        }
    }
}
