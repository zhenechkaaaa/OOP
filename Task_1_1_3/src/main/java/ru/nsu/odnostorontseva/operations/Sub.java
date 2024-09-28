package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a subtraction in expression.
 */
public class Sub extends Expression{

    private final Expression lPrt;
    private final Expression rPrt;

    /**
     * Constructing the subtraction operation.
     *
     * @param lPrt (левая часть выражения).
     * @param rPrt (правая часть выражения).
     */
    public Sub(Expression lPrt, Expression rPrt) {
        this.lPrt = lPrt;
        this.rPrt = rPrt;
    }

    @Override
    public String print() {
        return "(" + lPrt.print() + " - " + rPrt.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Sub(lPrt.derivative(var), rPrt.derivative(var));
    }

    @Override
    public int eval(Map<String, Integer> variables) {
        return lPrt.eval(variables) - rPrt.eval(variables);
    }
}
