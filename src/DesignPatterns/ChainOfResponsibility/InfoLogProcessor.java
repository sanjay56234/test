package DesignPatterns.ChainOfResponsibility;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor processor){
        super(processor);
    }

    public void log(int logLevel, String message){
        if(logLevel==INFO){
            System.out.println("Info printed");
        }else{
            super.log(logLevel,message);
        }
    }
}
