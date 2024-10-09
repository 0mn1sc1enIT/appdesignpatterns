public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(Logger.LogLevel.INFO);

        Thread t1 = new LoggingThread("This is an info message.", Logger.LogLevel.INFO);
        Thread t2 = new LoggingThread("This is a warning message.", Logger.LogLevel.WARNING);
        Thread t3 = new LoggingThread("This is an error message.", Logger.LogLevel.ERROR);
        Thread t4 = new LoggingThread("Another info message.", Logger.LogLevel.INFO);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LogReader logReader = new LogReader("application.log");
        System.out.println("Reading ERROR logs:");
        logReader.readLogs(Logger.LogLevel.ERROR);
    }
}
