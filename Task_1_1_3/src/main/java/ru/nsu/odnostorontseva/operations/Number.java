package ru.nsu.odnostorontseva.operations;

import java.util.Map;

/**
 * Class for representing a constant in expression.
 */
public class Number extends Expression{

    private final double num;

    /**
     * Constructing the constant.
     *
     * @param num (заничение константы).
     */
    public Number(double num) {
        this.num = num;
    }

    @Override
    public String print() {
        return String.valueOf(num);
    }

    @Override
    public Expression derivative(String var) {
        return new Number(0);
    }

    @Override
    public double eval(Map<String, Double> vars) {
        return num;
    }
}
