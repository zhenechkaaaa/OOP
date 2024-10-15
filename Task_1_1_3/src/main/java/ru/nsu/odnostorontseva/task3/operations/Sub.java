package ru.nsu.odnostorontseva.task3.operations;

import ru.nsu.odnostorontseva.task3.operands.Number;

/**
 * Class for representing a subtraction in expression.
 */
public class Sub extends Expression {

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the subtraction operation.
     *
     * @param leftPart  (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Sub(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    /**
     * Method which overrides the equals method to compare Expressions.
     *
     * @param o (объкт для сравнивания)
     * @return (запускает рекурсию для сравнения или t / f)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sub e)) {
            return false;
        }
        return this.leftPart.equals(e.leftPart) && this.rightPart.equals(e.rightPart);
    }

    @Override
    public int hashCode() {
        return leftPart.hashCode() + rightPart.hashCode();
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        if (moreSimpleLeftPart instanceof Number nl && moreSimpleRightPart instanceof Number nr) {
            return new Number(nl.getNum() - nr.getNum());
        }
        if (moreSimpleLeftPart.equals(moreSimpleRightPart)) {
            return new Number(0);
        }

        return new Sub(moreSimpleLeftPart, moreSimpleRightPart);
    }

    @Override
    public String toString() {
        return "(" + leftPart.toString() + " - " + rightPart.toString() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Sub(leftPart.derivative(var), rightPart.derivative(var));
    }

    @Override
    public double eval(String variables) {
        return leftPart.eval(variables) - rightPart.eval(variables);
    }
}