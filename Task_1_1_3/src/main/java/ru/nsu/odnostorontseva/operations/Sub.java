package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a subtraction in expression.
 */
public class Sub extends Expression{

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the subtraction operation.
     *
     * @param leftPart (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Sub(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public String print() {
        return "(" + leftPart.print() + "-" + rightPart.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Sub(leftPart.derivative(var), rightPart.derivative(var));
    }

    @Override
    public double eval(Map<String, Double> variables) {
        return leftPart.eval(variables) - rightPart.eval(variables);
    }
}
