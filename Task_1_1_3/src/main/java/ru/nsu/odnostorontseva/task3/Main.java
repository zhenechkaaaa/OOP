package ru.nsu.odnostorontseva.task3;

import ru.nsu.odnostorontseva.task3.operands.Number;
import ru.nsu.odnostorontseva.task3.operands.Variable;
import ru.nsu.odnostorontseva.task3.operations.*;

import java.util.Scanner;

/**
 * Main class for demonstration how expression classes work.
 */
public class Main {

    private static String text;
    private static int pos = 0;
    /**
     * basic method.
     *
     * @param args (не используется).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        text = scanner.nextLine();
        Expression expr = parseExpression();
        Expression moreSimpleExpr = expr.makeSimple();

        // Печать введенного выражения
        System.out.println("Введенное выражение: " + moreSimpleExpr.print());

        if(!(moreSimpleExpr instanceof ru.nsu.odnostorontseva.task3.operands.Number)) {
            // Ввод значений переменных
            System.out.println("Введите значения переменных:");
            String variables = scanner.nextLine();

            // Вычисление значения выражения
            System.out.println("Результат вычисления: " + moreSimpleExpr.eval(variables));

            // Ввод переменной для дифференцирования
            System.out.println("Введите переменную для дифференцирования:");
            String variableForDerivative = scanner.nextLine();

            // Дифференцирование и вывод результата
            Expression derivative = moreSimpleExpr.derivative(variableForDerivative);
            System.out.println("Производная: " + derivative.makeSimple().print());
        } else {
            // Дифференцирование и вывод результата
            Expression derivative = moreSimpleExpr.derivative("");
            System.out.println("Производная: " + derivative.makeSimple().print());
        }
    }

    /**
     * Метод для разбора выражения из строки.
     *
     * @return (Expression, представляющий это выражение).
     */
    public static Expression parseExpression() {
        pos = 0; // Сброс позиции
        return parseAdd();
    }

    private static Expression parseAdd() {
        Expression left = parseMul();
        while ("+".equals(peekToken()) || "-".equals(peekToken())) {
            String op = readToken();
            Expression right = parseMul();

            left = (op.equals("+")) ? new Add(left, right) : new Sub(left, right);
        }
        return left;
    }

    private static Expression parseMul() {
        Expression left = parseAtom();
        while ("*".equals(peekToken()) || "/".equals(peekToken())) {
            String op = readToken();
            Expression right = parseAtom();
            left = (op.equals("*")) ? new Mul(left, right) : new Div(left, right);
        }
        return left;
    }

    private static Expression parseAtom() {
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

    private static String readToken() {
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

    private static String peekToken() {
        int oldPos = pos;
        String token = readToken();
        pos = oldPos;
        return token;
    }
}
