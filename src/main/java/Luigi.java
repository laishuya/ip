import java.util.Scanner;
import java.util.ArrayList;
import tasks.*;
public class Luigi {
    private static ArrayList<Task> list = new ArrayList<>();

    private static void printList() {
        System.out.println("Here are your tasks:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static void deleteTask(int index) {
        Task task = list.get(index);
        list.remove(index);
        System.out.println("Noted. I've disposed of this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    private static void addToDo(String description) {
        Task task = new Todo(description);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    private static void addDeadline(String description, String by) {
        Task task = new Deadline(description, by);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    private static void addEvent(String description, String from, String to) {
        Task task = new Event(description, from, to);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
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

            String command = input.split(" ")[0];
            switch (command) {
                case "list":
                    printList();
                    break;

                case "mark":
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        mark(index);
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case "unmark":
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        unmark(index);
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case "todo":
                    try {
                        String description = input.substring(5).trim();
                        addToDo(description);
                    } catch (Exception e) {
                        System.out.println("Description of todo cannot be empty!");
                        System.out.println("Correct example: todo read book");
                    }
                    break;

                case "deadline":
                    try {
                        String[] deadlineParts = input.substring(9).trim().split(" /by ");
                        addDeadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                    } catch (Exception e) {
                        System.out.println("Please input description and deadline!");
                        System.out.println("Correct example: deadline return book /by tomorrow");
                    }
                    break;

                case "event":
                    try {
                        String[] eventParts = input.substring(6).trim().split(" /from | /to ");
                        addEvent(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
                    } catch (Exception e) {
                        System.out.println("Please input description, from (what time), to (what time)!");
                        System.out.println("Correct example: event book club meeting "
                            + "/from Tuesday 3 p.m. /to Tuesday 5 p.m.");
                     }
                    break;

                case "delete":
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        deleteTask(index);
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                default:
                    System.out.println("Sorry, invalid command");
                    break;
            }
        }
        System.out.println("Bye!");
        scanner.close();
    }

    private static void greetUser() {
        System.out.println("""
                Hello, I'm Luigi! How can I help you?
                """);
    }
}
