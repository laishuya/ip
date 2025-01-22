import java.util.Scanner;
import java.util.ArrayList;

public class Luigi {
    private static ArrayList<String> list = new ArrayList<>();

    private static void addItem(String item) {
        list.add(item);
        System.out.println("added: " + item);
    }

    private static void printList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {
        greetUser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("bye")) {
                break;
            }
            if (input.equals("list")) {
                printList();
            } else {
                addItem(input);
            }
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
