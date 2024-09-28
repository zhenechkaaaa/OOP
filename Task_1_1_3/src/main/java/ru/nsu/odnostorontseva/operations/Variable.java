package ru.nsu.odnostorontseva.operations;

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

    public String print() {
        return variable;
    }

    public Expression derivative (String var) {
        if(variable.equals(var)) {
            return new Number(1);
        }
        return new Number(0);
    }

    public int eval(Map<String, Integer> variables) {
        if (variables.containsKey(variable)) {
            return variables.get(variable);
        }
        throw new IllegalArgumentException("Переменная " + variables + " не определена.");
    }
}
