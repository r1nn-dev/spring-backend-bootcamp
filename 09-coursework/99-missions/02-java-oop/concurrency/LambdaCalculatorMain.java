package concurrency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * 5-2 실행 클래스 — 람다 사칙연산 계산기
 * 연산자 기호마다 계산 방법을 람다로 정의해 Map에 담는다. 연산자를 추가할 때 put 한 줄이면 된다.
 */
public class LambdaCalculatorMain {

    // DoubleBinaryOperator: double 두 개를 받아 double 하나를 돌려주는 함수형 인터페이스 (applyAsDouble)
    private static final Map<String, DoubleBinaryOperator> OPERATIONS = new LinkedHashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다."); // double은 0 나누기가 Infinity라 직접 검사
            }
            return a / b;
        });
    }

    public static void main(String[] args) {
        double a = 10;
        double b = 4;

        // 직접 계산한 기대값 (10, 4 기준). 람다 결과와 비교해 정상 동작을 확인한다
        Map<String, Double> expected = Map.of("+", 14.0, "-", 6.0, "*", 40.0, "/", 2.5);
        boolean allPassed = true;

        // 1. 네 연산을 같은 방식(applyAsDouble)으로 호출한다
        System.out.println("=== 람다 계산기: " + a + ", " + b + " ===");
        for (Map.Entry<String, DoubleBinaryOperator> entry : OPERATIONS.entrySet()) {
            String operator = entry.getKey();
            double result = entry.getValue().applyAsDouble(a, b);
            boolean match = result == expected.get(operator); // 이 값들은 double로 정확히 표현돼 == 비교 가능
            allPassed &= match;
            System.out.println(a + " " + operator + " " + b + " = " + result
                    + (match ? " (일치)" : " (불일치: 기대값 " + expected.get(operator) + ")"));
        }

        // 2. 예외 상황: 기대한 예외가 발생해야 통과
        System.out.println();
        System.out.println("=== 예외 상황 ===");
        allPassed &= expectError(10, "/", 0, ArithmeticException.class);
        allPassed &= expectError(10, "%", 4, IllegalArgumentException.class);

        // 3. 모든 결과가 기대와 같을 때만 정상 동작으로 판정한다
        System.out.println();
        System.out.println(allPassed ? "람다식 계산기 정상 동작" : "람다식 계산기 오류: 위의 (불일치) 항목 확인");
    }

    static double calculate(double a, String operator, double b) {
        DoubleBinaryOperator operation = OPERATIONS.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("'" + operator + "'은(는) 지원하지 않는 연산자입니다.");
        }
        return operation.applyAsDouble(a, b);
    }

    /** 계산 시 expectedType 예외가 발생하면 true. 예외 없이 계산되거나 다른 예외면 false. */
    private static boolean expectError(double a, String operator, double b,
                                       Class<? extends RuntimeException> expectedType) {
        String expression = a + " " + operator + " " + b;
        try {
            double result = calculate(a, operator, b);
            System.out.println(expression + " = " + result + " (불일치: " + expectedType.getSimpleName() + " 기대)");
            return false;
        } catch (RuntimeException e) {
            boolean match = expectedType.isInstance(e);
            System.out.println(expression + " → 오류: " + e.getMessage() + (match ? " (일치)" : " (불일치)"));
            return match;
        }
    }
}
