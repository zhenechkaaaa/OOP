package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals("10.0", moreSimpleE.print());
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
        Expression e = new Add(l,r);
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