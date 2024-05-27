package LoggerSystem.apender;

import LoggerSystem.modules.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
