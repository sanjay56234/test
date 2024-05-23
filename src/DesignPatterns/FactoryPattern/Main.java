package DesignPatterns.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        FactoryClass factoryClass = new FactoryClass();

        Shape shape = factoryClass.getShape("CIRCLE");
        shape.getShape();

        Shape shape1 = factoryClass.getShape("RECTANGLE");
        shape1.getShape();


    }
}
