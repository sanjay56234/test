package DesignPatterns.CompositeDesignPattern.Calculator;

public class Main {

    public static void main(String[] args) {
        Number number = new Number(10);
        Number number1 = new Number(2);

        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(number,number1, Operation.MUL);

        Number number3 = new Number(40);

        ArithmeticExpression arithmeticExpression1 = new ArithmeticExpression(number3, arithmeticExpression, Operation.SUB);
        System.out.println(arithmeticExpression1.evaluate());
    }

}
