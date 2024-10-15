package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Expression;
import ru.nsu.odnostorontseva.task3.operations.Sub;

class SubTest {

    @Test
    void makeSimpleWithoutVarsTest() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(6);
        Expression r = new ru.nsu.odnostorontseva.task3.operands.Number(4);
        Expression e = new Sub(l, r);
        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(2), moreSimpleE);
    }

    @Test
    void makeSimpleWithSamePartsTest() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression r = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression e = new Sub(l, r);
        Expression moreSimpleE = e.makeSimple();

        assertEquals(new Number(0), moreSimpleE);
    }

    @Test
    void equalsTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");

        Expression e = new Sub(l, r);
        Expression expected = new Sub(new Variable("x"), new Variable("y"));

        assertEquals(expected, e);
    }

    @Test
    void equalsNullTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Sub(l, r);

        assertNotEquals(null, e);
    }

    @Test
    void hashCodeTest() {
        Expression l = new Variable("x");
        Expression r = new Variable("y");
        Expression e = new Sub(l, r);
        Expression expected = new Sub(new Variable("x"), new Variable("y"));

        assertEquals(expected.hashCode(), e.hashCode());
    }

    @Test
    void print() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression r = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression e = new Sub(l, r);

        assertEquals("(5.0 - 5.0)", e.print());
    }

    @Test
    void derivative() {
        Expression l = new ru.nsu.odnostorontseva.task3.operands.Number(5);
        Expression r = new Variable("x");
        Expression e = new Sub(l, r);
        Expression der = e.derivative("x");

        assertEquals("(0.0 - 1.0)", der.print());
    }

    @Test
    void eval() {
        Expression l = new Number(5);
        Expression r = new Variable("x");
        Expression e = new Sub(l, r);

        assertEquals(2.0, e.eval("x = 3"));
    }
}