import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public boolean isQuitCommand(String input) {
        return input.equalsIgnoreCase("Q");
    }

    public boolean isEnterCommand(String input) {
        return input.isEmpty();
    }

    public boolean isDrawCommand(String input) {
        return input.equalsIgnoreCase("D");
    }

    public boolean isValidLength(String input) {
        return input.length() >= 2 && input.length() <= 4;
    }

    public boolean validNumMoves(int moves){
        return (moves <14);
    }

}
