package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a multiplication in expression.
 */
public class Mul extends Expression{

    private final Expression lPrt;
    private final Expression rPrt;

    /**
     * Constructing the multiplication.
     *
     * @param lPrt (левая часть выражения).
     * @param rPrt (правая часть выражения).
     */
    public Mul(Expression lPrt, Expression rPrt) {
        this.lPrt = lPrt;
        this.rPrt = rPrt;
    }

    @Override
    public String print() {
        return "(" + lPrt.print() + " * " + rPrt.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Add(
                new Mul(lPrt.derivative(var), rPrt),
                new Mul(lPrt, rPrt.derivative(var))
        );
    }

    @Override
    public int eval(Map<String, Integer> variables) {
        return lPrt.eval(variables) * rPrt.eval(variables);
    }
}
