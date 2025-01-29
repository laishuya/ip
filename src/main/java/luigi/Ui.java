package luigi;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
        greetUser();
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        this.scanner.close();
    }

    public void sayMessage(String message) {
        System.out.println(message);
    }

    private void greetUser() {
        System.out.println("""
                Hello, I'm Luigi! How can I help you?
                """);
    }
}
