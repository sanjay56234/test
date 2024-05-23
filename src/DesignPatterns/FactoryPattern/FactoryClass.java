package DesignPatterns.FactoryPattern;

public class FactoryClass {
    public Shape getShape(String type){

        switch (type){
            case "CIRCLE" :
                return new Circle();
            case   "RECTANGLE" :
                return new Rectangle();
            default:
                return null;
        }
    }
}
