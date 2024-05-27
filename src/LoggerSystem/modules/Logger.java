package LoggerSystem.modules;

import LoggerSystem.apender.ConsoleAppender;

public class Logger {
    private static Logger instance;

    private LoggerConfig loggerConfig;
    private Logger(){
        loggerConfig = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance(){
        if(instance==null){
            instance = new Logger();
        }
        return instance;
    }

    public static void setInstance(Logger instance) {
        Logger.instance = instance;
    }

    public LoggerConfig getLoggerConfig() {
        return loggerConfig;
    }

    public void setLoggerConfig(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= loggerConfig.getLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message, 345);
            loggerConfig.getLogAppender().append(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
