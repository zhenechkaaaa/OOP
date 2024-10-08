package ru.nsu.odnostorontseva.task3;

import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Div;
import ru.nsu.odnostorontseva.task3.operations.Expression;
import ru.nsu.odnostorontseva.task3.operations.Mul;
import ru.nsu.odnostorontseva.task3.operations.Sub;

/**
 * Class responsible for the expression parser.
 */
public class ExpressionParser {

    private final String text;
    private int pos = 0;

    /**
     * Method which constructs the parser.
     *
     * @param text (выражение, которое ввел пользователь)
     */
    public ExpressionParser(String text) {
        this.text = text.trim();
    }

    /**
     * Method which returns the parsed string in Expression-type.
     * Starts the recursion.
     *
     * @return (строка представленная в виде выражения типа:
     *      Expression e = new Add(new Number(3), new Mul(new Number(2),
     *      new Variable("x")));).
     */
    public Expression parse() {
        pos = 0; // Сброс позиции
        return parseAdd();
    }

    /**
     * Method for parsing the Add and Sub operations.
     *
     * @return (new Add/Sub выражение).
     */
    private Expression parseAdd() {
        Expression left = parseMul();
        while ("+".equals(peekToken()) || "-".equals(peekToken())) {
            String op = readToken();
            Expression right = parseMul();

            left = op.equals("+") ? new Add(left, right) : new Sub(left, right);
        }
        return left;
    }

    /**
     * Method for parsing the Mul and Div operations.
     *
     * @return (new Mul/Div выражение).
     */
    private Expression parseMul() {
        Expression left = parseAtom();
        while ("*".equals(peekToken()) || "/".equals(peekToken())) {
            String op = readToken();
            Expression right = parseAtom();
            left = op.equals("*") ? new Mul(left, right) : new Div(left, right);
        }
        return left;
    }

    /**
     * Method for parsing numbers and variables.
     *
     * @return (new Number, new Variable).
     */
    private Expression parseAtom() {
        String token = readToken();
        try {
            if ("(".equals(token)) {
                Expression expr = parseAdd();
                readToken(); // Убираем ')'
                return expr;
            } else if (token.matches("-?\\d+(\\.\\d+)?")) {
                return new Number(Double.parseDouble(token)); // Если это число
            } else if (token.matches("[a-zA-Z]+")) {
                return new Variable(token); // Если это переменная
            }
            throw new IllegalArgumentException("Неправильно введённое выражение: " + text);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Method which "read" text token in user-enter string.
     *
     * @return (строку или один символ, представляющий собой:
     *      число, или переменную, или символ операции, или скобки).
     */
    private String readToken() {
        StringBuilder sb = new StringBuilder();
        while (pos < text.length()
                && Character.isWhitespace(text.charAt(pos))) {
            pos++;
        }

        if (pos >= text.length()) {
            return "";
        }

        char cur = text.charAt(pos);
        if ("+-*/()".indexOf(cur) != -1) {
            pos++;
            return Character.toString(cur);
        }

        while (pos < text.length() && (Character.isDigit(text.charAt(pos))
                || Character.isLetter(text.charAt(pos)))) {
            sb.append(text.charAt(pos));
            pos++;
        }

        return sb.toString();
    }

    /**
     * Method allowing to view the next token without reading it.
     *
     * @return (следующий токен).
     */
    private String peekToken() {
        int oldPos = pos;
        String token = readToken();
        pos = oldPos;
        return token;
    }
}
