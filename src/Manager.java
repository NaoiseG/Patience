import java.util.Scanner;

public class Manager {
    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final GameProcessor gameProcessor;

    public Manager(){
        Deck deck = new Deck(); // Initialise deck

        this.gameBoard = new GameBoard(deck);
        this.inputHandler = new InputHandler(new Scanner(System.in));
        MoveHandler moveHandler = new MoveHandler(gameBoard);
        this.gameProcessor = new GameProcessor(gameBoard, inputHandler, moveHandler);

        if(startMessage()){
            play(); // Start game
        }
    }

    public void play(){
        String input;
        while (true){ // Loop until quit or win
            gameBoard.prompt();
            if(inputHandler.isQuitCommand(input = inputHandler.getInput())) { // Check for quit command
                gameBoard.printQuit();
                break;
            }

            if (inputHandler.isDrawCommand(input)){ //Check for draw
                gameBoard.Draw();
                gameBoard.addMove();
                continue;
            }
            else if(!inputHandler.isValidLength(input)){ //Check less than 5 characters entered
                gameBoard.printError("ERROR: INPUT \"" + input + "\" IS NOT VALID");
            }
            gameProcessor.processInput(input); //Valid input always passed

            if(gameBoard.checkWin())
                break;
        }
    }
    public boolean startMessage(){ // Check for 'Enter' to start game
        System.out.println("Welcome to the game!\n");
        System.out.println("These are the rules:");
        System.out.println("Press 'D' to draw a card");
        System.out.println("Press 'Q' to quit at any time");
        System.out.println("Moves can be made from label1 to label 2 by entering <label1><label2> or <number of moves><label1><label2>\n");
        System.out.println("Press 'Enter' to start or 'Q' to quit");
        String input = inputHandler.getInput();
        while(true){
            if(inputHandler.isQuitCommand(input)){
                gameBoard.printQuit();
                return false;
            }
            else if(inputHandler.isEnterCommand(input)){
                System.out.println("Starting Game\n");
                return true;
            }
            else{
                gameBoard.printError("ERROR: INPUT \"" + input + "\" IS NOT VALID");
                System.out.println("Press 'Enter' to start or 'Q' to quit");
                input = inputHandler.getInput();
            }
        }
    }
}
