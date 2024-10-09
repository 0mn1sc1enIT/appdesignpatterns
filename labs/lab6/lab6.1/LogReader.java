import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private String logFilePath;

    public LogReader(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void readLogs(Logger.LogLevel level) {
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(level.name())) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
