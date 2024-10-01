package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing the division in expression.
 */
public class Div extends Expression{

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the division.
     *
     * @param leftPart (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Div(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public String print() {
        return "(" + leftPart.print() + " / " + rightPart.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Div(
                new Sub(
                        new Mul(leftPart.derivative(var), rightPart),
                        new Mul(leftPart, rightPart.derivative(var))
                ),
                new Mul(rightPart, rightPart)
        );
    }

    @Override
    public double eval(Map<String, Double> variables) {
        double left = leftPart.eval(variables);
        double right = rightPart.eval(variables);
        if (right == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
        return left/right;
    }
}
