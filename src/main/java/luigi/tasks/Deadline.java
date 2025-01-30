package luigi.tasks;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Deadline extends Task {
    private LocalDateTime by;
    private static final String INPUT_FORMAT = "yyyy-MM-dd HHmm";
    private static final String DISPLAY_FORMAT = "MMM dd yyyy HH:mm";

    /**
     * Creates a Deadline object that contains the due date of the tasks.
     *
     * @param description Task description.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.by = LocalDateTime.parse(by, format);
    }

    public LocalDate getLocalDate() {
        return this.by.toLocalDate();
    }

    /**
     * Converts information of the Deadline into a string, to be saved in data file.
     */
    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s", "D", getStatusNumber(),
                this.description, this.by.format(format));
    }

    /**
     * Returns the string information of the Deadline, to be displayed to users.
     */
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[D]" + super.toString() + " (by: "
                + this.by.format(format) + ")";
    }
}