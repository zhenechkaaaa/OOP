package ru.nsu.odnostorontseva.task3;

import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.Add;
import ru.nsu.odnostorontseva.task3.operations.Div;
import ru.nsu.odnostorontseva.task3.operations.Expression;
import ru.nsu.odnostorontseva.task3.operations.Mul;
import ru.nsu.odnostorontseva.task3.operations.Sub;

public class ExpressionParser {

    private String text;
    private int pos = 0;

    public ExpressionParser(String text) {
        this.text = text;
    }

    public Expression parse() {
        pos = 0; // Сброс позиции
        return parseAdd();
    }

    private Expression parseAdd() {
        Expression left = parseMul();
        while ("+".equals(peekToken()) || "-".equals(peekToken())) {
            String op = readToken();
            Expression right = parseMul();

            left = (op.equals("+")) ? new Add(left, right) : new Sub(left, right);
        }
        return left;
    }

    private Expression parseMul() {
        Expression left = parseAtom();
        while ("*".equals(peekToken()) || "/".equals(peekToken())) {
            String op = readToken();
            Expression right = parseAtom();
            left = (op.equals("*")) ? new Mul(left, right) : new Div(left, right);
        }
        return left;
    }

    private Expression parseAtom() {
        String token = readToken();
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
    }

    private String readToken() {
        StringBuilder sb = new StringBuilder();
        text = text.trim();

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

    private String peekToken() {
        int oldPos = pos;
        String token = readToken();
        pos = oldPos;
        return token;
    }
}
