package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Expression;
import ru.nsu.odnostorontseva.task3.operations.Mul;

class MulTest {

    @Test
    void makeSimpleWithNoVarsTest() {
        Expression l = new Number(5);
        Expression r = new Number(5);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(25), moreSimpleE);
    }

    @Test
    void makeSimpleWithLeftZeroTest() {
        Expression l = new Number(0);
        Expression r = new Number(5);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(0), moreSimpleE);
    }

    @Test
    void makeSimpleWithRightZeroTest() {
        Expression l = new Number(5);
        Expression r = new Number(0);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(0), moreSimpleE);
    }

    @Test
    void makeSimpleWithLeftOneTest() {
        Expression l = new Number(1);
        Expression r = new Number(5);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(5), moreSimpleE);
    }

    @Test
    void makeSimpleWithRightOneTest() {
        Expression l = new Number(5);
        Expression r = new Number(1);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(5), moreSimpleE);
    }

    @Test
    void equalsTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");

        Expression e = new Mul(l, r);
        Expression expected = new Mul(new Variable("x"), new Variable("y"));

        assertEquals(expected, e);
    }

    @Test
    void equalsNullTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Mul(l, r);

        assertNotEquals(null, e);
    }

    @Test
    void hashCodeTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Mul(l, r);
        Expression expected = new Mul(new Variable("x"), new Variable("y"));

        assertEquals(expected.hashCode(), e.hashCode());
    }

    @Test
    void printTest() {
        Expression l = new Number(5);
        Expression r = new Variable("x");
        Expression e = new Mul(l, r);

        assertEquals("(5.0 * x)", e.print());
    }

    @Test
    void derivativeTest() {
        Expression l = new Add(new Number(5), new Variable("x")); //((5+x)*x)
        Expression r = new Variable("x");

        Expression e = new Mul(l, r);
        Expression der = e.derivative("x");
        Expression moreSimpleDer = der.makeSimple();

        assertEquals("(x + (5.0 + x))", moreSimpleDer.print());
    }

    @Test
    void evalTest() {
        Expression l = new Number(5);
        Expression r = new Variable("x");
        Expression e = new Mul(l, r);

        assertEquals(10.0, e.eval("x = 2"));
    }
}