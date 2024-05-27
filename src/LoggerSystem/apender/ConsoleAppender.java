package LoggerSystem.apender;

import LoggerSystem.modules.LogMessage;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.getMessage());
    }
}
