package rectangle;

import java.util.Scanner;

/**
 * 5-3 실행 클래스
 * 가로·세로를 입력받아 Rectangle 객체를 만들고 넓이·둘레 메서드를 호출한다.
 * 객체마다 상태가 따로 있다는 것과, 잘못된 값으로는 객체가 만들어지지 않는 것도 확인한다.
 */
public class RectangleMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. 입력한 값으로 객체 생성 → 메서드 호출
            int width = readPositiveInt(scanner, "가로를 입력하세요: ");
            int height = readPositiveInt(scanner, "세로를 입력하세요: ");
            Rectangle input = new Rectangle(width, height);

            System.out.println();
            System.out.println(input); // toString() 자동 호출
            System.out.println("넓이 = " + input.area());
            System.out.println("둘레 = " + input.perimeter());
            System.out.printf("가로=%d, 세로=%d 입력 시 넓이=%d, 둘레=%d%n",
                    input.getWidth(), input.getHeight(), input.area(), input.perimeter());

            // 2. 같은 클래스로 만든 객체라도 필드 값은 각자 가진다
            Rectangle square = new Rectangle(4, 4);
            System.out.println();
            System.out.println("다른 객체: " + square + " → 넓이=" + square.area() + ", 둘레=" + square.perimeter());
            System.out.println("처음 객체: " + input + " → 넓이=" + input.area() + " (값 그대로)");

            // 3. 0 이하 길이는 생성자에서 거부된다
            System.out.println();
            try {
                new Rectangle(0, 3);
            } catch (IllegalArgumentException e) {
                System.out.println("생성 실패: " + e.getMessage());
            }
        }
    }

    /** 1 이상의 정수가 입력될 때까지 다시 묻는다. (M04 방식: nextLine() + 변환) */
    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("0보다 큰 정수를 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "'은(는) 정수가 아닙니다. 다시 입력하세요.");
            }
        }
    }
}
