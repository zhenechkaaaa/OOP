package ru.nsu.odnostorontseva.task3.operands;

import ru.nsu.odnostorontseva.task3.operations.Expression;

import java.util.Map;

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
    public Expression derivative (String var) {
        if(variable.equals(var)) {
            return new ru.nsu.odnostorontseva.task3.operands.Number(1);
        }
        return new Number(0);
    }

    @Override
    public double eval(Map<String, Double> variables) {
        if (variables.containsKey(variable)) {
            return variables.get(variable);
        }
        throw new IllegalArgumentException("Переменная " + variables + " не определена.");
    }
}
