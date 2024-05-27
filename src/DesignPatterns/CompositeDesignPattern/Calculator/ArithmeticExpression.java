package DesignPatterns.CompositeDesignPattern.Calculator;

public class ArithmeticExpression implements Expression {

    Expression left;
    Expression right;

    Operation operation;

    public ArithmeticExpression(Expression left, Expression right, Operation operation){
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public Integer evaluate() {
        switch (this.operation){
            case ADD:
                return left.evaluate() + right.evaluate();
            case DIV:
                return left.evaluate() / right.evaluate();
            case MUL:
                return left.evaluate() * right.evaluate();
            case SUB:
                return left.evaluate() - right.evaluate();
            default:
                return null;
        }
    }

}
