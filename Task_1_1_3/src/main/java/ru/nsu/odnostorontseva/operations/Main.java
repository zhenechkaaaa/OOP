package ru.nsu.odnostorontseva.operations;

import java.util.Scanner;

/**
 * Main class for demonstration how expression classes work.
 */
public class Main {

    /**
     * Method for parsing an expression from string.
     *
     * @param expr (строковое выражение).
     * @return (Expression, представляющий это выражение).
     */
    public static Expression parseExpression(String expr) {
        expr = expr.trim(); //убираем лишние пробелы

        if (expr.isEmpty()) {
            throw new IllegalArgumentException("Вы ввели пустое выражение.");
        }

        if (expr.matches("-?\\d+(\\.\\d+)?")) {
            return new Number(Double.parseDouble(expr)); // Если это число
        } else if (expr.matches("[a-zA-Z]+")) {
            return new Variable(expr); // Если это переменная
        } else if (expr.startsWith("(") && expr.endsWith(")")) {
            // Убираем внешние скобки
            expr = expr.substring(1, expr.length() - 1).trim();

            int depth = 0;
            for (int i = 0; i < expr.length(); i++) {
                char c = expr.charAt(i);
                if (c == '(') depth++;
                if (c == ')') depth--;
                if (depth == 0 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                    Expression left = parseExpression(expr.substring(0, i).trim());
                    Expression right = parseExpression(expr.substring(i + 1).trim());
                    switch (c) {
                        case '+': return new Add(left, right);
                        case '-': return new Sub(left, right);
                        case '*': return new Mul(left, right);
                        case '/': return new Div(left, right);
                    }
                }
            }
        }
        throw new IllegalArgumentException("Неправильно введённое выражение: " + expr);
    }

    /**
     * basic method.
     *
     * @param args (не используется).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        Expression expr = parseExpression(input);

        // Печать введенного выражения
        System.out.println("Введенное выражение: " + expr.print());

        // Ввод значений переменных
        System.out.println("Введите значения переменных:");
        String variables = scanner.nextLine();

        // Вычисление значения выражения
        System.out.println("Результат вычисления: " + expr.eval(variables));

        // Ввод переменной для дифференцирования
        System.out.println("Введите переменную для дифференцирования:");
        String variableForDerivative = scanner.nextLine();

        // Дифференцирование и вывод результата
        Expression derivative = expr.derivative(variableForDerivative);
        System.out.println("Производная: " + derivative.print());

        // Вычисление производной
        System.out.println("Результат вычисления производной: " + derivative.eval(variables));
    }
}
