package luigi.ui;

import java.util.Scanner;

/**
 * Interacts with the user by printing statements.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs Ui object that greets the user and asks for user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
        greetUser();
    }

    /**
     * Reads the next line of input entered.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        this.scanner.close();
    }

    /**
     * Welcomes the user when Luigi is initialised.
     */
    private void greetUser() {
        System.out.println("Hello, I'm Luigi!\nHow can I help you?");
    }
}

