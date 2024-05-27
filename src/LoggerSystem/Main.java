package LoggerSystem;

import LoggerSystem.apender.FileAppender;
import LoggerSystem.modules.LogLevel;
import LoggerSystem.modules.Logger;
import LoggerSystem.modules.LoggerConfig;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Logging with default configuration
        logger.info("This is an information message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

        // Changing log level and appender
        LoggerConfig config = new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log"));
        logger.setLoggerConfig(config);

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}
