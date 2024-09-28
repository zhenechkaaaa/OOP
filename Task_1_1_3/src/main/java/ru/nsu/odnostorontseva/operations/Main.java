package ru.nsu.odnostorontseva.operations;

/**
 * Main class for demonstration how expression classes work.
 */
public class Main {
    /**
     * basic method.
     *
     * @param args (не используется).
     */
    public static void main(String[] args) {

        Expression e = new Add(new Number(3), new Mul(new Number(2), new Variable("x")));

        System.out.println("Expression: " + e.print());

        String vars = "x=10; y=13";
        System.out.println("Evaluated result: " + e.eval(vars));

        Expression derivative = e.derivative("x");
        System.out.println("Derivative: " + derivative.print());

        System.out.println("Evaluated derivative: " + derivative.eval(vars));
    }
}
