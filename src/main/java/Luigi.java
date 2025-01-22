import java.util.Scanner;
import java.util.ArrayList;

public class Luigi {
    private static ArrayList<Task> list = new ArrayList<>();

    private static void addItem(String item) {
        Task task = new Task(item);
        list.add(task);
        System.out.println("added: " + item);
    }

    private static void printList() {
        System.out.println("Here are your tasks: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static void mark(int index) {
        Task task = list.get(index);
        task.mark();
        System.out.println("Successfully marked!");
        System.out.println("  " + task);
    }

    private static void unmark(int index) {
        Task task = list.get(index);
        task.unmark();
        System.out.println("Successfully unmarked!");
        System.out.println("  " + task);
    }
    public static void main(String[] args) {
        greetUser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("bye")) {
                break;
            }
            else if (input.equals("list")) {
                printList();
            }
            else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                mark(index);
            }
            else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                unmark(index);
            }
            else {
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
