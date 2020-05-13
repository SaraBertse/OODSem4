package se.kth.sem4.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is responsible for printing a text log.
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "sale_error.txt";
    private PrintWriter logFile;
    
    /**
     * Creates a new instance of LogHandler.
     * 
     * @throws IOException if the program is not working correctly.
     */
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }
    
    /**
     * Writes a log entry for a thrown exception.
     * 
     * @param exc The thrown exception that should be logged.
     */
    public void logException(Exception exc) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exc.getMessage());
        logFile.println(logMsgBuilder);
        exc.printStackTrace(logFile);
    }

    /**
     * Creates a string with the time at that moment.
     * 
     * @return The formatted string with the time.
     */
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    } 
}
