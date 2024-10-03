package ru.nsu.odnostorontseva.task3.operations;

import ru.nsu.odnostorontseva.task3.operands.Number;

/**
 * Class for representing a multiplication in expression.
 */
public class Mul extends Expression {

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the multiplication.
     *
     * @param leftPart (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Mul(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        if(moreSimpleLeftPart instanceof Number && moreSimpleRightPart instanceof Number) {
            return new Number(moreSimpleLeftPart.eval("") * moreSimpleRightPart.eval(""));
        } else if (moreSimpleLeftPart instanceof Number && moreSimpleLeftPart.print().equals("0.0")) {
            return new Number(0);
        } else if (moreSimpleRightPart instanceof Number && moreSimpleRightPart.print().equals("0.0")) {
            return new Number(0);
        } else if (moreSimpleLeftPart instanceof Number && moreSimpleLeftPart.print().equals("1.0")) {
            return moreSimpleRightPart;
        } else if (moreSimpleRightPart instanceof Number && moreSimpleRightPart.print().equals("1.0")) {
            return moreSimpleLeftPart;
        }

        return new Mul(moreSimpleLeftPart, moreSimpleRightPart);
    }

    @Override
    public String print() {
        return "(" + leftPart.print() + " * " + rightPart.print() + ")";
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