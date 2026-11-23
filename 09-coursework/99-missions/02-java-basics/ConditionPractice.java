import java.util.Scanner;

/**
 * 4-4 조건문 활용 프로그램
 * 숫자 → 짝수/홀수 판별 (if/else), 점수 → 학점 A~F (switch).
 * 학점 기준: 90 이상 A, 80 이상 B, 70 이상 C, 60 이상 D, 그 외 F
 */
public class ConditionPractice {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = readInt(scanner, "정수를 입력하세요: ");
            System.out.println(number + "은(는) " + evenOrOdd(number) + "입니다.");

            System.out.println();
            int score = readScore(scanner);
            System.out.println("점수 " + score + "점의 학점은 '" + grade(score) + "'입니다.");
        }
    }

    /**
     * 짝수/홀수 판별 (if/else).
     * 음수 홀수는 -3 % 2 == -1 이므로 "== 1"이 아니라 "== 0"(짝수)으로 비교한다.
     */
    static String evenOrOdd(int number) {
        if (number % 2 == 0) {
            return "짝수";
        } else {
            return "홀수";
        }
    }

    /**
     * 학점 계산 (switch, Java 14+ 화살표 문법).
     * 점수를 10으로 나눈 몫(10, 9, 8, ...)으로 구간을 나눈다. 100점은 몫이 10이라 A에 함께 넣는다.
     */
    static char grade(int score) {
        return switch (score / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }

    /** 0~100 범위의 점수가 입력될 때까지 다시 묻는다 (범위 검사는 if). */
    private static int readScore(Scanner scanner) {
        while (true) {
            int score = readInt(scanner, "점수(0~100)를 입력하세요: ");
            if (score >= 0 && score <= 100) {
                return score;
            }
            System.out.println("점수는 0~100 사이여야 합니다. 다시 입력하세요.");
        }
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
