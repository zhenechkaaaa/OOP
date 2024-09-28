package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing an add operation in expression.
 */
public class Add extends Expression{

    private final Expression lPrt;
    private final Expression rPrt;

    /**
     * Constructing the adding operation.
     *
     * @param lPrt (левая часть выражения).
     * @param rPrt (правая часть выражения).
     */
    public Add(Expression lPrt, Expression rPrt) {
        this.lPrt = lPrt;
        this.rPrt = rPrt;
    }

    @Override
    public String print() {
        return "(" + lPrt.print() + " + " + rPrt.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Add(lPrt.derivative(var), rPrt.derivative(var));
    }

    @Override
    public int eval(Map<String, Integer> variables) {
        return lPrt.eval(variables) + rPrt.eval(variables);
    }
}
