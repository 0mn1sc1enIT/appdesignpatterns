public class DRY {
    //task 1
    public class Logger {
        private void Log(String LogLevel, String message) {
            System.out.println(LogLevel + ": " + message);
        }

        public void LogError(String message) {
            Log("ERROR", message);
        }

        public void LogWarning(String message) {
            Log("WARNING", message);
        }

        public void LogInfo(String message) {
            Log("INFO", message);
        }
    }

    //task 2
    public class Cfg {
        public static final String connect = "Server=myServer;Database=myDb;User Id=myUser;Password=myPass;";
    }

    public class DatabaseService {
        public void connect() {
            String connectionString = Cfg.connect;
            // Логика подключения к базе данных
        }
    }

    public class LoggingService {
        public void log(String message) {
            String connectionString = Cfg.connect;
            // Логика записи лога в базу данных
        }
    }
}
