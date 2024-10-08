package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals("25.0", moreSimpleE.print());
    }

    @Test
    void makeSimpleWithLeftZeroTest() {
        Expression l = new Number(0);
        Expression r = new Number(5);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals("0.0", moreSimpleE.print());
    }

    @Test
    void makeSimpleWithRightZeroTest() {
        Expression l = new Number(5);
        Expression r = new Number(0);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals("0.0", moreSimpleE.print());
    }

    @Test
    void makeSimpleWithLeftOneTest() {
        Expression l = new Number(1);
        Expression r = new Number(5);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals("5.0", moreSimpleE.print());
    }

    @Test
    void makeSimpleWithRightOneTest() {
        Expression l = new Number(5);
        Expression r = new Number(1);
        Expression e = new Mul(l, r);

        Expression moreSimpleE = e.makeSimple();

        assertEquals("5.0", moreSimpleE.print());
    }

    @Test
    void print() {
        Expression l = new Number(5);
        Expression r = new Variable("x");
        Expression e = new Mul(l, r);

        assertEquals("(5.0 * x)", e.print());
    }

    @Test
    void derivative() {
        Expression l = new Add(new Number(5), new Variable("x")); //((5+x)*x)
        Expression r = new Variable("x");

        Expression e = new Mul(l, r);
        Expression der = e.derivative("x");
        Expression moreSimpleDer = der.makeSimple();

        assertEquals("(x + (5.0 + x))", moreSimpleDer.print());
    }

    @Test
    void eval() {
        Expression l = new Number(5);
        Expression r = new Variable("x");
        Expression e = new Mul(l, r);

        assertEquals(10.0, e.eval("x = 2"));
    }
}