package ru.nsu.odnostorontseva.task3;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Div;
import ru.nsu.odnostorontseva.task3.operations.Expression;
import ru.nsu.odnostorontseva.task3.operations.Mul;
import ru.nsu.odnostorontseva.task3.operations.Sub;

public class ExpressionParserTest {

    @Test
    public void parseNumTest() {
        ExpressionParser parser = new ExpressionParser("42");
        Expression expr = parser.parse();

        assertInstanceOf(Number.class, expr);
    }

    @Test
    public void parseVarTest() {
        ExpressionParser parser = new ExpressionParser("x");
        Expression expr = parser.parse();

        assertInstanceOf(Variable.class, expr);
    }

    @Test
    public void parseSimpleAddTest() {
        ExpressionParser parser = new ExpressionParser("3 + 5");
        Expression expr = parser.parse();

        assertInstanceOf(Add.class, expr);
    }

    @Test
    public void parseSimpleSubTest() {
        ExpressionParser parser = new ExpressionParser("10 - 7");
        Expression expr = parser.parse();

        assertInstanceOf(Sub.class, expr);
    }

    @Test
    public void parseMulTest() {
        ExpressionParser parser = new ExpressionParser("4 * 6");
        Expression expr = parser.parse();

        assertInstanceOf(Mul.class, expr);
    }

    @Test
    public void parseDivTest() {
        ExpressionParser parser = new ExpressionParser("8 / 4");
        Expression expr = parser.parse();

        assertInstanceOf(Div.class, expr);
    }

    @Test
    public void parseExWithVarsTest() {
        ExpressionParser parser = new ExpressionParser("2 * x + 3");
        Expression expr = parser.parse();

        assertInstanceOf(Add.class, expr);
    }

    @Test
    public void parseExWithParenthesesTest() {
        ExpressionParser parser = new ExpressionParser("(2 + 3) * 4");
        Expression expr = parser.parse();

        assertInstanceOf(Mul.class, expr);
    }

    @Test
    public void parseNestedParenthesesTest() {
        ExpressionParser parser = new ExpressionParser("(1 + (2 * 3)) - 4");
        Expression expr = parser.parse();

        assertInstanceOf(Sub.class, expr);
    }

    @Test
    public void parseInvalidExpressionTest() {
        ExpressionParser parser = new ExpressionParser("2 + @");

        try {
            parser.parse();
        } catch (IllegalArgumentException ex) {
            assertInstanceOf(IllegalArgumentException.class, ex);
        }
    }
}
