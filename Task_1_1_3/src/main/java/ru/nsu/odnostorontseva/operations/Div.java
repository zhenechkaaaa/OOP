package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing the division in expression.
 */
public class Div extends Expression{

    private final Expression lPrt;
    private final Expression rPrt;

    /**
     * Constructing the division.
     *
     * @param lPrt (левая часть выражения).
     * @param rPrt (правая часть выражения).
     */
    public Div(Expression lPrt, Expression rPrt) {
        this.lPrt = lPrt;
        this.rPrt = rPrt;
    }

    @Override
    public String print() {
        return "(" + lPrt.print() + " / " + rPrt.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Div(
                new Sub(
                        new Mul(lPrt.derivative(var), rPrt),
                        new Mul(lPrt, rPrt.derivative(var))
                ),
                new Mul(rPrt, rPrt)
        );
    }

    @Override
    public int eval(Map<String, Integer> variables) {
        return lPrt.eval(variables) / rPrt.eval(variables);
    }
}
