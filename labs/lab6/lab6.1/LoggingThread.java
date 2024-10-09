public class LoggingThread extends Thread {
    private String message;
    private Logger.LogLevel level;

    public LoggingThread(String message, Logger.LogLevel level) {
        this.message = message;
        this.level = level;
    }

    @Override
    public void run() {
        Logger logger = Logger.getInstance();
        logger.log(message, level);
    }
}
