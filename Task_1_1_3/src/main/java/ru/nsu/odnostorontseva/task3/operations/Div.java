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
        if (!(o instanceof Div e)) {
            return false;
        }
        return this.leftPart.equals(e.leftPart) && this.rightPart.equals(e.rightPart);
    }

    @Override
    public int hashCode() {
        return this.leftPart.hashCode() / this.rightPart.hashCode();
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        if (moreSimpleLeftPart instanceof Number nl
                && moreSimpleRightPart instanceof Number nr) {
            if (nr.getNum() == 0) {
                throw new ArithmeticException("Деление на ноль.");
            } else if (nr.getNum() == 1) {
                return moreSimpleLeftPart;
            } else if (nr.getNum() == nl.getNum()) {
                return new Number(1);
            }
            return new Number(nl.getNum()/nr.getNum());
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
        double res;
        try {
            res = left / right;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на ноль.");
        }
        return res;
    }
}