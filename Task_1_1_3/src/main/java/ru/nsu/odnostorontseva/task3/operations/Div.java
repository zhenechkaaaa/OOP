package ru.nsu.odnostorontseva.task3.operations;

import ru.nsu.odnostorontseva.task3.operands.Number;

/**
 * Class for representing the division in expression.
 */
public class Div extends Expression {

    public final Expression leftPart;
    public final Expression rightPart;

    /**
     * Constructing the division.
     *
     * @param leftPart  (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Div(Expression leftPart, Expression rightPart) {
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
        if (o == null) {
            return false;
        }
        if (o instanceof Div e) {
            return this.leftPart.equals(e.leftPart) && rightPart.equals(e.leftPart);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.leftPart.hashCode() / this.rightPart.hashCode();
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        try {
            if (moreSimpleRightPart.equals(new Number(0))) {
                throw new ArithmeticException("Деление на ноль.");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

        if (moreSimpleLeftPart instanceof Number
                && moreSimpleRightPart instanceof Number) {
            return new Number(moreSimpleLeftPart.eval("")
                    / moreSimpleRightPart.eval(""));
        } else if (moreSimpleRightPart instanceof Number
                && moreSimpleRightPart.equals(new Number(1))) {
            return moreSimpleLeftPart;
        } else if (moreSimpleRightPart.equals(moreSimpleLeftPart)) {
            return new Number(1);
        }
        return new Div(moreSimpleLeftPart, moreSimpleRightPart);
    }


    @Override
    public String toString() {
        return "(" + leftPart.toString() + " / " + rightPart.toString() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Div(
                new Sub(
                        new Mul(leftPart.derivative(var), rightPart),
                        new Mul(leftPart, rightPart.derivative(var))
                ),
                new Mul(rightPart, rightPart)
        );
    }

    @Override
    public double eval(String variables) {
        double left = leftPart.eval(variables);
        double right = rightPart.eval(variables);
        try {
            if (right == 0) {
                throw new ArithmeticException("Деление на ноль.");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        return left / right;
    }
}