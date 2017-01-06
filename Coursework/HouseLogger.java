import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/**
 * Provides functionality for logging the daily state of a house and a momentary state
 */
public class HouseLogger {
    private static final String LOG_SEPARATOR = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
    private static final String ERROR_LOG_FILE_NAME = "errorLogs.txt";

    private Path houseLogFile;
    private Path errorLogFile;

    public HouseLogger(String fileName) {
        this.houseLogFile = Paths.get(fileName);
        this.errorLogFile = Paths.get(ERROR_LOG_FILE_NAME);
    }

    /**
     * Tries to write to a log file the given lines. If it fails it logs the error to the default errorLogFile.
     * If that fails as well then prints the stack trace on the console.
     * @param file the file to write to(uses append mode)
     * @param lines the content to write
     */
    private void writeToFile(Path file, List<String> lines) {
        try {
            // Create new file if non exists or append to current log
            StandardOpenOption option = Files.exists(file) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW;
            Files.write(file, lines, Charset.forName("UTF-8"), option);
        } catch (IOException e) {
            // Get the stackTrace as string
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String exceptionString = sw.toString();

            // Prepare log to be date and exception
            Date now = new Date();
            List<String> errorLines = Arrays.asList("[" + now.toString() + "]", exceptionString);

            try {
                // Try to log to errorFile and give notice. If error log fails, show the error
                StandardOpenOption option = Files.exists(this.errorLogFile) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW;
                Files.write(this.errorLogFile, errorLines, Charset.forName("UTF-8"), option);
                System.out.println("Logging failed. Error logged in " + ERROR_LOG_FILE_NAME);
            } catch (IOException errLogEx) {
                errLogEx.printStackTrace();
            }
        }
    }

    /**
     * Creates and writes to the houseLogFile a snapshot of the house.
     * Day, time, timePassed. All appliances and all people with their tasks, what is on, when it's going to be off
     * and all meter readings at the moment.
     * @param house the house to be logged
     */
    public void logState(House house) {
        List<String> lines = new ArrayList<>();

        Date now = new Date();

        // Show day, time and timePassed
        lines.add(LOG_SEPARATOR);
        lines.add("[STATE][" + now.toString() + "]" + "[DAY - " + house.dayCount + "][TIME - " + house.timePassed + "]");

        // Show appliances descriptions
        lines.add("");
        lines.add("Appliances:");
        for (Appliance appliance : house.appliances) {
            lines.add(appliance.toString() + "\n");
        }

        // Show people and their tasks
        lines.add("People:");
        for (Person person : house.people) {
            lines.add(person.toString() + "\n");
        }

        // Show the current readings all meters that are connected
        lines.add("Current meter values:");
        lines.add("Electric meter - " + (house.electricMeter != null ? house.electricMeter.getConsumed() : "no meter"));
        lines.add("Gas meter - " + (house.gasMeter != null ? house.gasMeter.getConsumed() : "no meter"));
        lines.add("Water meter - " + (house.waterMeter != null ? house.waterMeter.getConsumed() : "no meter"));
        lines.add("");

        this.writeToFile(this.houseLogFile, lines);
    }

    /**
     * Creates and writes to the houseLogFile a daily consumption log.
     * The current day with all it's consumption.
     * @param day the current day count
     * @param electricityConsumption the current day electricity consumption
     * @param gasConsumption the current day gas consumption
     * @param waterConsumption the current day water consumption
     */
    public void logDailyConsumption(int day, int electricityConsumption, int gasConsumption, int waterConsumption) {
        List<String> lines = new ArrayList<>();
        Date now = new Date();

        // Preparing log to be date, simulation day and daily consumption
        lines.add(LOG_SEPARATOR);
        lines.add("[DAILY][" + now.toString() + "]" + "[DAY - " + day + "]");
        lines.add("Electricity - " + electricityConsumption);
        lines.add("Gas - " + gasConsumption);
        lines.add("Water - " + waterConsumption);
        lines.add("");

        this.writeToFile(this.houseLogFile, lines);
    }
}
