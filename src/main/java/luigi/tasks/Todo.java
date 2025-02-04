package luigi.tasks;

/**
 * Represents a Task that has to be done.
 */
public class Todo extends Task {

    /**
     * Creates a Todo task object that contains details about the Task to be completed.
     *
     * @param description More information about the Task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts information of the Event into a string, to be saved in data file.
     */
    @Override
    public String saveStringInFile() {
        return String.format("%s | %d | %s", "T", getStatusNumber(),
                this.description);
    }

    /**
     * Returns the string information of the Event, to be displayed to users.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
