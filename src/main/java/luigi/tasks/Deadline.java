package luigi.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Represents a Task with a due date, which includes date, year and time.
 */
public class Deadline extends Task {
    private static final String DISPLAY_FORMAT = "MMM dd yyyy HH:mm";
    private static final String INPUT_FORMAT = "yyyy-MM-dd HHmm";
    private LocalDateTime deadline;

    /**
     * Creates a Deadline object that contains the due date of the tasks.
     *
     * @param description Task description.
     * @param deadline The due date of the task.
     */
    public Deadline(String description, String deadline) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.deadline = LocalDateTime.parse(deadline, format);
    }

    /**
     * Returns the due date of the Deadline Task.
     */
    public LocalDate getLocalDateOfDeadline() {
        return this.deadline.toLocalDate();
    }

    /**
     * Returns the due date and time of the Dealdine Task.
     */
    public LocalDateTime getLocalDateTimeOfDeadline() {
        return this.deadline;
    }

    /**
     * Converts information of the Deadline into a string, to be saved in data file.
     */
    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s", "D", getStatusNumber(),
                this.description, this.deadline.format(format));
    }

    /**
     * Returns the string information of the Deadline, to be displayed to users.
     */
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[D]" + super.toString() + " (by: "
                + this.deadline.format(format) + ")";
    }
}
