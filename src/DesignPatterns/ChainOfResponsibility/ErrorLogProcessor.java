package DesignPatterns.ChainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel== ERROR){
            System.out.println("Error printed");
        }else{
            super.log(logLevel,message);
        }
    }
}
