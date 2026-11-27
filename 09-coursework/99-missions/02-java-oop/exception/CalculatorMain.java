package exception;

import java.util.Scanner;

/**
 * 5-4 예외 처리 계산기
 * 두 수와 연산자를 입력받아 계산한다. 잘못된 입력·연산이 있어도 프로그램이 멈추지 않고 안내 후 계속한다.
 * calculate()는 예외를 던지기만 하고, 안내 문구는 main의 catch에서 정한다.
 */
public class CalculatorMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("사칙연산 계산기 (+, -, *, /) — 첫 번째 수에 q를 입력하면 종료");

            while (true) {
                System.out.println();
                System.out.print("첫 번째 수: ");
                String first = scanner.nextLine().trim();
                if (first.equalsIgnoreCase("q")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
                System.out.print("연산자: ");
                String operator = scanner.nextLine().trim();
                System.out.print("두 번째 수: ");
                String second = scanner.nextLine().trim();

                try {
                    double a = parseNumber(first);
                    double b = parseNumber(second);
                    double result = calculate(a, operator, b);
                    System.out.println("결과: " + a + " " + operator + " " + b + " = " + result);
                } catch (NumberFormatException e) {
                    // NumberFormatException은 IllegalArgumentException의 자식이라 먼저 잡아야 한다
                    System.out.println("오류: " + e.getMessage());
                } catch (ArithmeticException e) {
                    System.out.println("오류: 나눌 수 없음 — " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                } finally {
                    System.out.println("------------------------------"); // 성공·실패와 관계없이 항상 실행
                }
            }
        }
    }

    /** 문자열을 숫자로 바꾼다. NaN·Infinity처럼 계산에 쓸 수 없는 값도 거부한다. */
    static double parseNumber(String input) {
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("'" + input + "'은(는) 숫자가 아닙니다.");
        }
        if (!Double.isFinite(value)) {
            throw new NumberFormatException("'" + input + "'은(는) 계산할 수 없는 값입니다.");
        }
        return value;
    }

    /**
     * 사칙연산. double은 0으로 나눠도 예외 없이 Infinity가 되므로 직접 검사해 예외를 던진다.
     *
     * @throws ArithmeticException      0으로 나눌 때
     * @throws IllegalArgumentException 지원하지 않는 연산자일 때
     */
    static double calculate(double a, String operator, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException(
                    "'" + operator + "'은(는) 지원하지 않는 연산자입니다. (+, -, *, / 중 하나)");
        };
    }
}
