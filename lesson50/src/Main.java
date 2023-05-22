import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        HistoryManager historyManager = new HistoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите выражение ('q' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                double result = calculator.evaluateExpression(input);
                System.out.println("Результат: " + result);

                historyManager.saveExpression(input, result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (EmptyStackException e) {
                System.out.println("Ошибка в уравнении");
            }
        }

        List<String> history = historyManager.loadHistory();
        System.out.println("История вычислений:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}

class Calculator {
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    private double executeOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '%':
                return num1 % num2;
            case '^':
                return Math.pow(num1, num2);
            case '|':
                return Math.abs(num2); // Операция модуля числа
            default:
                throw new IllegalArgumentException("Неверный оператор: " + operator);
        }
    }

    public double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                StringBuilder numBuilder = new StringBuilder();
                numBuilder.append(currentChar);

                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    numBuilder.append(expression.charAt(i + 1));
                    i++;
                }

                double number = Double.parseDouble(numBuilder.toString());
                numbers.push(number);
            } else if (currentChar == '(') {
                operators.push(currentChar);
            } else if (currentChar == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char operator = operators.pop();
                    double num2 = numbers.pop();
                    double num1 = numbers.pop();
                    double result = executeOperation(num1, num2, operator);
                    numbers.push(result);
                }

                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
            } else if (isOperator(currentChar)) {
                while (!operators.isEmpty() && getOperatorPriority(operators.peek()) >= getOperatorPriority(currentChar)) {
                    char operator = operators.pop();
                    double num2 = numbers.pop();
                    double num1 = numbers.pop();
                    double result = executeOperation(num1, num2, operator);
                    numbers.push(result);
                }

                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty()) {
            char operator = operators.pop();
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            double result = executeOperation(num1, num2, operator);
            numbers.push(result);
        }

        return numbers.pop();
    }

    private int getOperatorPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
            case '|':
                return 3;
            default:
                return 0;
        }
    }
}

class HistoryManager {
    private static final String HISTORY_FILE = "history.txt";

    public void saveExpression(String expression, double result) {
        try (FileWriter writer = new FileWriter(HISTORY_FILE, true)) {
            String entry = expression + " = " + result + System.lineSeparator();
            writer.write(entry);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории: " + e.getMessage());
        }
    }

    public List<String> loadHistory() {
        List<String> history = new ArrayList<>();
        try {
            history = Files.readAllLines(Path.of(HISTORY_FILE));
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке истории: " + e.getMessage());
        }
        return history;
    }
}