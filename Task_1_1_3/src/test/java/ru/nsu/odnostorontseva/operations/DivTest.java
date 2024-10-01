package ru.nsu.odnostorontseva.operations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.operations.*;

class DivTest {

    @Test
    void print() {
        Expression firstNum = new Number(7.8);
        Expression secondNum = new Number(9.8);

        Div division = new Div(firstNum, secondNum);

        assertEquals("(7.8 / 9.8)", division.print());
    }

    @Test
    void derivative() {
    }

    @Test
    void eval() {
    }
}