package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Div;
import ru.nsu.odnostorontseva.task3.operations.Expression;


class DivTest {

    @Test
    void makeSimpleWithNumsTest() {
        Expression l = new Number(4);
        Expression r = new Number(8);
        Expression e = new Div(l, r);
        Expression moreSimpE = e.makeSimple();

        assertEquals(new Number(0.5), moreSimpE);
    }

    @Test
    void makeSimpleWithRightOneTest() {
        Expression l = new Number(4);
        Expression r = new Number(1);
        Expression e = new Div(l, r);
        Expression moreSimpE = e.makeSimple();

        assertEquals(new Number(4), moreSimpE);
    }

    @Test
    void divisionByZeroTest() {
        Expression l = new Number(4);
        Expression r = new Number(0);
        Expression e = new Div(l, r);

        try {
            e.makeSimple();
        } catch (ArithmeticException ex) {
            assertInstanceOf(Exception.class, ex);
        }
    }

    @Test
    void makeSimpleWithSamePartsTest() {
        Expression l = new Add(new Number(4), new Number(5));
        Expression r = new Add(new Number(4), new Number(5));
        Expression e = new Div(l, r);
        Expression moreSimpE = e.makeSimple();

        assertEquals(new Number(1), moreSimpE);
    }

    @Test
    void printTest() {
        Expression l = new Number(4);
        Expression r = new Number(8);
        Expression e = new Div(l, r);

        assertEquals("(4.0 / 8.0)", e.print());
    }

    @Test
    void derivativeTest() {
        Expression l = new Add(new Number(5), new Variable("x")); //((5+x)/x)
        Expression r = new Variable("x");

        Expression e = new Div(l, r);
        Expression der = e.derivative("x");
        Expression moreSimpleDer = der.makeSimple();

        assertEquals("((x - (5.0 + x)) / (x * x))", moreSimpleDer.print());
    }

    @Test
    void evalTest() {
        Expression l = new Add(new Number(5), new Variable("x"));
        Expression r = new Variable("x");

        Expression e = new Div(l, r);
        assertEquals(6.0, e.eval("x = 1"));
    }

    @Test
    void evalDivisionByZeroTest() {
        Expression l = new Add(new Number(5), new Variable("x"));
        Expression r = new Variable("x");
        Expression e = new Div(l, r);

        try {
            e.eval("x = 0");
        }
        catch (ArithmeticException ex) {
            assertInstanceOf(Exception.class, ex);
        }
    }


}