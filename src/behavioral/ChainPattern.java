package behavioral;

abstract class Logger {
    protected Logger nextLogger;
    public void setNextLogger(Logger nextLogger) { this.nextLogger = nextLogger; }
    public void logMessage(String message) {
        System.out.println("Логування: " + message);
        if (nextLogger != null) { nextLogger.logMessage(message); }
    }
}
class ConsoleLogger extends Logger {}

public class ChainPattern {
    public static void run() {
        Logger logger1 = new ConsoleLogger();
        Logger logger2 = new ConsoleLogger();
        logger1.setNextLogger(logger2);
        logger1.logMessage("Ланцюжок працює!");
    }
}