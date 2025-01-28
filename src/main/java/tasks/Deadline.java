package tasks;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Deadline extends Task {
    private LocalDateTime by;
    private static final String INPUT_FORMAT = "yyyy-MM-dd HHmm";
    private static final String DISPLAY_FORMAT = "MMM dd yyyy HH:mm";

    public Deadline(String description, String by) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.by = LocalDateTime.parse(by, format);
    }

    public LocalDate getLocalDate() {
        return this.by.toLocalDate();
    }

    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s", "D", getStatusNumber(),
                this.description, this.by.format(format));
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[D]" + super.toString() + " (by: "
                + this.by.format(format) + ")";
    }
}