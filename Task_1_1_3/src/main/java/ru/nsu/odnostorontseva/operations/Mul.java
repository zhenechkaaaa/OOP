package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a multiplication in expression.
 */
public class Mul extends Expression{

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the multiplication.
     *
     * @param leftPart (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Mul(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public String print() {
        return "(" + leftPart.print() + "*" + rightPart.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Add(
                new Mul(leftPart.derivative(var), rightPart),
                new Mul(leftPart, rightPart.derivative(var))
        );
    }

    @Override
    public double eval(Map<String, Double> variables) {
        return leftPart.eval(variables) * rightPart.eval(variables);
    }
}
