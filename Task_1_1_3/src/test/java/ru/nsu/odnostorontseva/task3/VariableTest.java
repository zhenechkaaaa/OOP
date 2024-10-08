package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Expression;

class VariableTest {

    @Test
    void makeSimpleTest() {
        Expression e = new Variable("x");
        Expression moreSimpleE = e.makeSimple();

        assertEquals("x", moreSimpleE.print());
    }

    @Test
    void printTest() {
        Expression e = new Variable("x");

        assertEquals("x", e.print());
    }

    @Test
    void derivativeWithTheCorrectVar() {
        Expression e = new Variable("x");
        Expression der = e.derivative("x");

        assertEquals("1.0", der.print());
    }

    @Test
    void derivativeWithTheDifferentVar() {
        Expression e = new Variable("x");
        Expression der = e.derivative("y");

        assertEquals("0.0", der.print());
    }

    @Test
    void evalCorrectTest() {
        Expression e = new Variable("x");
        String vars = "x = 10; y = 5";

        assertEquals(10.0, e.eval(vars));
    }
}