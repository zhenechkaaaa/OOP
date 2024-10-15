package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Expression;

class AddTest {

    @Test
    void makeSimpleTest() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(4);
        Expression r = new ru.nsu.odnostorontseva.task3.operands.Number(6);
        Expression e = new Add(l, r);
        Expression moreSimpleE = e.makeSimple();

        assertEquals(moreSimpleE, new Number(10));
    }

    @Test
    void equalsTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");

        Expression e = new Add(l, r);
        Expression expected = new Add(new Variable("x"), new Variable("y"));

        assertEquals(expected, e);
    }

    @Test
    void equalsNullTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Add(l, r);

        assertNotEquals(null, e);
    }

    @Test
    void hashCodeTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Add(l, r);
        Expression expected = new Add(new Variable("x"), new Variable("y"));

        assertEquals(expected.hashCode(), e.hashCode());
    }

    @Test
    void printTest() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression r = new Variable("x");
        Expression e = new Add(l, r);

        assertEquals("(5.0 + x)", e.print());
    }

    @Test
    void derivativeTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Add(l, r);
        Expression der = e.derivative("x");

        assertEquals("(1.0 + 0.0)", der.print());
    }

    @Test
    void evalTest() {
        Expression l = new Number(1);
        Expression r = new Variable("x");
        Expression e = new Add(l, r);

        assertEquals(11.0, e.eval("x = 10"));
    }
}