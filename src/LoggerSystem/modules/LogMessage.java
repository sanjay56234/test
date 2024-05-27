package LoggerSystem.modules;

import java.sql.Timestamp;

public class LogMessage {
    private final String message;
    private final long timestamp;

    private final LogLevel level;

    public LogMessage(LogLevel logLevel, String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
        this.level = logLevel;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + level + "] " + timestamp + " - " + message;
    }

}
