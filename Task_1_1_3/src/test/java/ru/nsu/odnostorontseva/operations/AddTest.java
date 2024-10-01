package ru.nsu.odnostorontseva.operations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.operations.Expression;
import ru.nsu.odnostorontseva.operations.Number;
import ru.nsu.odnostorontseva.operations.Variable;
import ru.nsu.odnostorontseva.operations.Add;

class AddTest {

    @Test
    void printTest() {
        Expression firstNum = new Number(7.8);
        Expression secondNum = new Number(9.8);

        Add sum = new Add(firstNum, secondNum);

        assertEquals("(7.8 + 9.8)", sum.print());
    }

    @Test
    void derivativeTest() {
        Expression lftPrt = new Variable("x");
        Expression rghtPrt = new Number(99);
        Add sum = new Add(lftPrt, rghtPrt);

        Expression der = sum.derivative("x");

        assertEquals("(1.0 + 0.0)", der.print());

    }

    @Test
    void evalWithNumAndVarTest() {
        Expression firstNum = new Number(1);
        Expression secondNum = new Variable("x");

        Add sum = new Add(firstNum, secondNum);

        assertEquals(6.0, sum.eval("x = 5"));
    }

    @Test
    void evalWithNumsTest() {
        Expression firstNum = new Number(1);
        Expression secondNum = new Number(9);

        Add sum = new Add(firstNum, secondNum);

        assertEquals(10.0, sum.eval("x = 7"));
    }

    @Test
    void evalWithVarsTest() {
        Expression firstVar = new Variable("y");
        Expression secondVar = new Variable("x");

        Add sum = new Add(firstVar, secondVar);

        assertEquals(7.0, sum.eval("x = 5; y = 2"));
    }
}