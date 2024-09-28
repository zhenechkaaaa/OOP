package ru.nsu.odnostorontseva.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for math expressions.
 * Defines basic operations for all expressions:
 * printing, differentiation and calculation.
 */
public abstract class Expression {

    /**
     * Returns string representation of expression
     *
     * @return (строковое представление строки).
     */
    public abstract String print();

    /**
     * Performs symbolic differentiation of an expression.
     *
     * @param var (пременная по которой происходит дифференцирование).
     * @return (строковое представление производной).
     */
    public abstract Expression derivative(String var);

    /**
     * Calculates the value of the expression.
     *
     * @param vars (строка с заданными згаченями переменной).
     * @return (целочисленный результат вычисления выражения).
     */
    public int eval(String vars) {
        Map<String, Integer> variables = parseVars(vars);
        return eval(variables);
    }

    /**
     * Calculates the value of the expression.
     *
     * @param variables (Map, где ключ - переменная, значение - числовое значение)
     * @return (целочисленный результат вычисления выражения)
     */
    protected abstract int eval(Map<String, Integer> variables);

    /**
     * Parses a string of variable meanings.
     *
     * @param input (строка в формате "переменная = значение").
     * @return map переменной и значения.
     */
    private Map<String, Integer> parseVars(String input) {
        Map<String, Integer> variables = new HashMap<>();
        String[] assignments = input.split(";");
        for (String i: assignments) {
            String[] parts = i.split("=");
            if (parts.length == 2) {
                String varName = parts[0].trim();
                int varValue = Integer.parseInt(parts[1].trim());
                variables.put(varName, varValue);
            }
        }
        return variables;
    }
}
