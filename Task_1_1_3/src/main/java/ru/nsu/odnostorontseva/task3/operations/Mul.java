package ru.nsu.odnostorontseva.task3.operations;

import ru.nsu.odnostorontseva.task3.operands.Number;

/**
 * Class for representing a multiplication in expression.
 */
public class Mul extends Expression {

    public final Expression leftPart;
    public final Expression rightPart;

    /**
     * Constructing the multiplication.
     *
     * @param leftPart  (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Mul(Expression leftPart, Expression rightPart) {
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
        if (!(o instanceof Mul e)) {
            return false;
        }
        return this.leftPart.equals(e.leftPart) && this.rightPart.equals(e.rightPart);
    }

    @Override
    public int hashCode() {
        return this.leftPart.hashCode() * this.rightPart.hashCode();
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        if (moreSimpleLeftPart instanceof Number nl && moreSimpleRightPart instanceof Number nr) {
            return new Number(nl.getNum() * nr.getNum());
        } else if (moreSimpleLeftPart.equals(new Number(0))) {
            return new Number(0);
        } else if (moreSimpleRightPart.equals(new Number(0))) {
            return new Number(0);
        } else if (moreSimpleLeftPart.equals(new Number(1))) {
            return moreSimpleRightPart;
        } else if (moreSimpleRightPart.equals(new Number(1))) {
            return moreSimpleLeftPart;
        }

        return new Mul(moreSimpleLeftPart, moreSimpleRightPart);
    }

    @Override
    public String toString() {
        return "(" + leftPart.toString() + " * " + rightPart.toString() + ")";
    }

    @Override
    public Expression derivative(String var) {
        return new Add(
                new Mul(leftPart.derivative(var), rightPart),
                new Mul(leftPart, rightPart.derivative(var))
        );
    }

    @Override
    public double eval(String variables) {
        return leftPart.eval(variables) * rightPart.eval(variables);
    }
}