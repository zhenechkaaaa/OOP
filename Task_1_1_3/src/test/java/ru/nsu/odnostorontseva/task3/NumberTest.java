package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operations.Expression;

class NumberTest {

    @Test
    void print() {
        Expression e = new Number(5);

        assertEquals("5.0", e.print());
    }

    @Test
    void derivative() {
        Expression e = new Number(5);
        Expression der = e.derivative("");

        assertEquals("0.0", der.print());
    }
}