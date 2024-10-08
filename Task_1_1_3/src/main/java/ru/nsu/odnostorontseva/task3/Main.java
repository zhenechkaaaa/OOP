package ru.nsu.odnostorontseva.task3;

import ru.nsu.odnostorontseva.task3.operations.Expression;

import java.util.Scanner;

/**
 * Main class for demonstration how expression classes work.
 */
public class Main {
    /**
     * basic method.
     *
     * @param args (не используется).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String text = scanner.nextLine();
        ExpressionParser parser = new ExpressionParser(text);
        Expression expr = parser.parse();
        Expression moreSimpleExpr = expr.makeSimple();

        if(moreSimpleExpr == null)
        {
            return;
        }

        // Печать введенного выражения
        System.out.println("Введенное выражение: " + moreSimpleExpr.print());

        if(!(moreSimpleExpr instanceof ru.nsu.odnostorontseva.task3.operands.Number)) {
            // Ввод значений переменных
            System.out.println("Введите значения переменных:");
            String variables = scanner.nextLine();

            // Вычисление значения выражения
            double res = moreSimpleExpr.eval(variables);
            if (Double.isNaN(res)){
                return;
            }
            System.out.println("Результат вычисления: " + res);

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
}
