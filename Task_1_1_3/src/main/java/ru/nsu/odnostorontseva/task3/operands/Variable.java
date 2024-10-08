package ru.nsu.odnostorontseva.task3.operands;

import ru.nsu.odnostorontseva.task3.operations.Expression;

/**
 * Class for representing a variable in expression.
 */
public class Variable extends Expression {

    private final String variable;

    /**
     * Constructing the variable.
     *
     * @param variable (имя переменной).
     */
    public Variable(String variable) {
        this.variable = variable;
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
        if (o instanceof Variable e) {
            return this.variable.equals(e.variable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.variable.hashCode();
    }

    @Override
    public Expression makeSimple() {
        return this;
    }

    @Override
    public String print() {
        return variable;
    }

    @Override
    public Expression derivative(String var) {
        if (variable.equals(var)) {
            return new Number(1);
        }
        return new Number(0);
    }

    @Override
    public double eval(String variables) {
        String vars = variables.trim();
        String[] assignments = vars.split(";");
        double varValue;
        try {
            for (String i : assignments) {
                String[] parts = i.split("=");
                if (parts.length == 2) {
                    String varName = parts[0].trim();
                    if (varName.equals(variable)) {
                        try {
                            varValue = Double.parseDouble(parts[1].trim());
                        } catch (NumberFormatException e) {
                            System.err.println(e.getMessage());
                            varValue = Double.NaN;
                        }
                        return varValue;
                    }
                }
            }
            throw new IllegalArgumentException("Переменная " + variable + " не определена.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return Double.NaN;
    }
}
