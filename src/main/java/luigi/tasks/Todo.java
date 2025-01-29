package luigi.tasks;
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String saveStringInFile() {
        return String.format("%s | %d | %s", "T", getStatusNumber(),
                this.description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
