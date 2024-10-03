package ru.nsu.odnostorontseva.task3.operations;

import ru.nsu.odnostorontseva.task3.operands.Number;

import java.util.Objects;

/**
 * Class for representing the division in expression.
 */
public class Div extends Expression {

    private final Expression leftPart;
    private final Expression rightPart;

    /**
     * Constructing the division.
     *
     * @param leftPart (левая часть выражения).
     * @param rightPart (правая часть выражения).
     */
    public Div(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public Expression makeSimple() {
        Expression moreSimpleLeftPart = leftPart.makeSimple();
        Expression moreSimpleRightPart = rightPart.makeSimple();

        if(moreSimpleLeftPart instanceof Number
                && moreSimpleRightPart instanceof Number
                && !Objects.equals(moreSimpleRightPart.print(), "0.0")) {
            return new Number(moreSimpleLeftPart.eval("")
                    / moreSimpleRightPart.eval(""));
        } else if (moreSimpleRightPart instanceof Number
                && moreSimpleRightPart.print().equals("1.0")) {
            return moreSimpleLeftPart;
        } else if (moreSimpleRightPart.equals(moreSimpleLeftPart)
                && !Objects.equals(moreSimpleRightPart.print(), "0.0")) {
            return new Number(1);
        }

        try {
            if (moreSimpleRightPart instanceof Number
                    && moreSimpleRightPart.print().equals("0.0")) {
                throw new ArithmeticException("Деление на ноль.");
            }
        }catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

        return new Div(moreSimpleLeftPart, moreSimpleRightPart);
    }

    @Override
    public String print() {
        return "(" + leftPart.print() + " / " + rightPart.print() + ")";
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
        try{
            if (right == 0) {
                throw new ArithmeticException("Деление на ноль.");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        return left/right;
    }
}