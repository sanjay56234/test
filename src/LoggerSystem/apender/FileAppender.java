package LoggerSystem.apender;

import LoggerSystem.modules.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private final String filePath;

    public FileAppender(String path){
        this.filePath = path;
    }
    @Override
    public void append(LogMessage logMessage) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
