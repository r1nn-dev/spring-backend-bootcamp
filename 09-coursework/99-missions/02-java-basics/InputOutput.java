import java.util.Scanner;

/**
 * 4-1 입력과 출력 기본 실습
 * Scanner로 이름과 나이를 입력받아 출력한다.
 */
public class InputOutput {

    public static void main(String[] args) {
        // try-with-resources: 블록이 끝나면 Scanner를 자동으로 닫는다
        try (Scanner scanner = new Scanner(System.in)) {
            String name = readName(scanner);
            int age = readAge(scanner);

            System.out.println();
            System.out.println("안녕하세요, " + name + "님! 나이는 " + age + "살이군요.");
            System.out.printf("입력값 출력 성공: 이름=%s, 나이=%d%n", name, age);
        }
    }

    /** 이름 입력. 공백이 들어간 이름도 받도록 nextLine()으로 한 줄 전체를 읽는다. */
    private static String readName(Scanner scanner) {
        while (true) {
            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("이름은 비워 둘 수 없습니다. 다시 입력하세요.");
        }
    }

    /**
     * 나이 입력. nextInt() 대신 nextLine()으로 읽고 정수로 바꾼다.
     * (nextInt()는 줄바꿈을 남겨 다음 nextLine()이 빈 문자열을 읽는 문제가 있고,
     *  숫자가 아니면 InputMismatchException이 난다.)
     */
    private static int readAge(Scanner scanner) {
        while (true) {
            System.out.print("나이를 입력하세요: ");
            String input = scanner.nextLine().trim();
            try {
                int age = Integer.parseInt(input);
                if (age >= 0 && age <= 150) {
                    return age;
                }
                System.out.println("나이는 0~150 사이로 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "'은(는) 숫자가 아닙니다. 다시 입력하세요.");
            }
        }
    }
}
