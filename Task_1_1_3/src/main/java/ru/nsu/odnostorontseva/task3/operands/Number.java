package ru.nsu.odnostorontseva.task3.operands;

import ru.nsu.odnostorontseva.task3.operations.Expression;

/**
 * Class for representing a constant in expression.
 */
public class Number extends Expression {

    private final double num;

    /**
     * Constructing the constant.
     *
     * @param num (заничение константы).
     */
    public Number(double num) {
        this.num = num;
    }

    /**
     * Method returns a nam.
     *
     * @return (num).
     */
    public double getNum() {
        return num;
    }

    /**
     * Method which overrides the equals method to compare Expressions.
     *
     * @param o (объкт для сравнивания)
     * @return (t / f)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Number e) {
            return this.num == e.num;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public Expression makeSimple() {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public Expression derivative(String var) {
        return new Number(0);
    }

    @Override
    public double eval(String vars) {
        return num;
    }
}