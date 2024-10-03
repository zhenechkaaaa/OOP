package ru.nsu.odnostorontseva.task3.operations;

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
     */
    public abstract double eval(String vars);
}
