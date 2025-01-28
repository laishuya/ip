package tasks;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Event extends Task {
    private static final String INPUT_FORMAT = "yyyy-MM-dd HHmm";
    private static final String DISPLAY_FORMAT = "MMM dd yyyy HH:mm";
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, String from, String to) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.from = LocalDateTime.parse(from, format);
        this.to = LocalDateTime.parse(to, format);
    }

    public LocalDate getFromLocalDate() {
        return this.from.toLocalDate();
    }

    public LocalDate getToLocalDate() {
        return this.to.toLocalDate();
    }

    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s | %s", "E", getStatusNumber(),
                this.description, this.from.format(format), this.to.format(format));
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[E]" + super.toString() + " (from: "
                + this.from.format(format) + " to: " + this.to.format(format) + ")";
    }
}