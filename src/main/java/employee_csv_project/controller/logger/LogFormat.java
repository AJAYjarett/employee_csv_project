package employee_csv_project.controller.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormat extends Formatter {

    @Override
    public String format(LogRecord record) {
        return getFormat() + " " + record.getLevel() + " " + record.getMessage() + "\n";
    }

    private String getFormat() {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }
}
