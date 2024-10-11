import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    public enum LogLevel {
        INFO,
        WARNING,
        ERROR
    }

    private static Logger instance;
    private static final Lock lock = new ReentrantLock();
    private LogLevel currentLogLevel;
    private String logFilePath;

    private Logger() {
        this.currentLogLevel = LogLevel.INFO; // Уровень по умолчанию
        this.logFilePath = "application.log"; // Путь к лог-файлу по умолчанию
    }

    public static Logger getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new Logger();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void log(String message, LogLevel level) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            try (FileWriter fw = new FileWriter(logFilePath, true);
                 PrintWriter out = new PrintWriter(fw)) {
                LocalDateTime notFormatTime = LocalDateTime.now();
                DateTimeFormatter FormatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String time = notFormatTime.format(FormatTime);
                out.println(STR."(\{level}) (\{time}) \{message}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    public void loadConfiguration(String configFilePath) {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(configFilePath)));
            this.logFilePath = properties.getProperty("logFilePath", this.logFilePath);
            String logLevel = properties.getProperty("logLevel", currentLogLevel.name());
            this.currentLogLevel = LogLevel.valueOf(logLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
