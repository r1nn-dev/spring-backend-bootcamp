import java.util.Arrays;
import java.util.Scanner;

/**
 * 4-2 메서드 활용 프로그램
 * 두 정수의 합/차, 정수 배열의 평균을 메서드로 계산한다.
 * 계산 메서드는 입출력 없이 값을 받아 결과만 반환한다.
 */
public class MethodPractice {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = readInt(scanner, "첫 번째 정수를 입력하세요: ");
            int b = readInt(scanner, "두 번째 정수를 입력하세요: ");

            int[] numbers = {a, b}; // 평균은 입력한 두 정수로 만든 배열로 계산

            System.out.println();
            System.out.println("합 = " + sum(a, b));
            System.out.println("차 = " + difference(a, b));
            System.out.println("평균 " + Arrays.toString(numbers) + " = " + average(numbers));
            // "5와 3"처럼 쓰면 숫자에 따라 조사(와/과)가 틀릴 수 있어 쉼표로 구분
            System.out.printf("%d, %d 입력 시 합=%d, 차=%d, 평균=%.1f%n",
                    a, b, sum(a, b), difference(a, b), average(numbers));

            // 빈 배열은 평균을 정의할 수 없으므로 예외로 알린다
            try {
                average(new int[0]);
            } catch (IllegalArgumentException e) {
                System.out.println("빈 배열 평균: " + e.getMessage());
            }
        }
    }

    /** 두 정수의 합 */
    static int sum(int a, int b) {
        return a + b;
    }

    /** 두 정수의 차 (a - b) */
    static int difference(int a, int b) {
        return a - b;
    }

    /** 정수 배열의 평균. 정수 나눗셈을 피하려고 double로 바꿔 나눈다. */
    static double average(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("배열이 비어 있어 평균을 계산할 수 없습니다.");
        }
        long total = 0; // 큰 수를 여러 개 더해도 넘치지 않게 long 사용
        for (int number : numbers) {
            total += number;
        }
        return (double) total / numbers.length;
    }

    /** 정수가 입력될 때까지 다시 묻는다. */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "'은(는) 정수가 아닙니다. 다시 입력하세요.");
            }
        }
    }
}
