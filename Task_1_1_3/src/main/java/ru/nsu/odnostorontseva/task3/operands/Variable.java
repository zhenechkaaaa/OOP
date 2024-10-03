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
            return new ru.nsu.odnostorontseva.task3.operands.Number(1);
        }
        return new Number(0);
    }

    @Override
    public double eval(String variables) {
        String vars = variables.trim();
        String[] assignments = vars.split(";");
        for (String i : assignments) {
            String[] parts = i.split("=");
            if (parts.length == 2) {
                String varName = parts[0].trim();
                if (varName.equals(variable)) {
                    double varValue;
                    try {
                        varValue = Double.parseDouble(parts[1]);
                    } catch (Exception e) {
                        System.err.println("Неправильный формат((");
                        varValue = 1;
                    }
                    return varValue;
                }
            }
        }
        throw new IllegalArgumentException("Переменная " + variable + " не определена.");
    }
}
