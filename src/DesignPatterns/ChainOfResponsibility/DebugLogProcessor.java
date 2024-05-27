package DesignPatterns.ChainOfResponsibility;

public class DebugLogProcessor extends LogProcessor {

    DebugLogProcessor(LogProcessor processor){
        super(processor);
    }

    public void log(int logLevel, String message){
        if(logLevel == DEBUG){
            System.out.println("Debug printed");
        }else{
            super.log(logLevel,message);
        }
    }


}
