package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a multiplication in expression.
 */
public class Mul extends Expression{

    private final Expression l_prt;
    private final Expression r_prt;

    /**
     * Constructing the multiplication.
     *
     * @param l_prt (левая часть выражения).
     * @param r_prt (правая часть выражения).
     */
    public Mul(Expression l_prt, Expression r_prt) {
        this.l_prt = l_prt;
        this.r_prt = r_prt;
    }

    @Override
    public String print() {
        return "(" + l_prt.print() + " * " + r_prt.print() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Add(
                new Mul(l_prt.derivative(var), r_prt),
                new Mul(l_prt, r_prt.derivative(var))
        );
    }

    @Override
    public int eval(Map<String, Integer> variables) {
        return l_prt.eval(variables) * r_prt.eval(variables);
    }
}
