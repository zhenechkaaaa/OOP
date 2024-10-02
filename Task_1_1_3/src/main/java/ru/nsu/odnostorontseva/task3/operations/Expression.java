package ru.nsu.odnostorontseva.task3.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for math expressions.
 * Defines basic operations for all expressions:
 * printing, differentiation and calculation.
 */
public abstract class Expression {

    /**
     * Method which will help make an expression more simple.
     *
     * @return (упрощенное выражение).
     */
    public abstract Expression makeSimple();

    /**
     * Method which helps print the expression.
     *
     * @return (строковое представление выражения)
     */
    public abstract String print();

    /**
     * Performs symbolic differentiation of an expression.
     *
     * @param var (пременная по которой происходит дифференцирование).
     * @return (производная в виде выражения).
     */
    public abstract Expression derivative(String var);

    /**
     * Calculates the value of the expression.
     *
     * @param vars (строка с заданными згаченями переменной).
     * @return (результат вычисления выражения).
     */
    public double eval(String vars) {
        Map<String, Double> variables = parseVars(vars);
        return eval(variables);
    }

    /**
     * Calculates the value of the expression.
     *
     * @param variables (Map, где ключ - переменная, значение - числовое значение)
     * @return (целочисленный результат вычисления выражения)
     */
    protected abstract double eval(Map<String, Double> variables);

    /**
     * Parses a string of variable meanings.
     *
     * @param input (строка в формате "переменная = значение").
     * @return (отображение переменной и значения).
     */
    private Map<String, Double> parseVars(String input) {
        Map<String, Double> variables = new HashMap<>();
        String[] assignments = input.split(";");
        for (String i: assignments) {
            String[] parts = i.split("=");
            if (parts.length == 2) {
                String varName = parts[0].trim();
                double varValue = Integer.parseInt(parts[1].trim());
                variables.put(varName, varValue);
            }
        }
        return variables;
    }
}
