import java.util.Scanner;

public class Luigi {
    public static void main(String[] args) {
        greetUser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                break;
            }
            System.out.println(input);
        }
        System.out.println("Bye!");
        scanner.close();
    }

    private static void greetUser() {
        System.out.println("""
                Hello, I'm Luigi! How can I help you?
                Bye!
                """);
    }
}
