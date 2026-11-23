/**
 * 4-3 반복문 활용 프로그램
 * 1~100 합계를 for와 while로 각각 구하고, 중첩 for로 구구단 2~9단을 출력한다.
 */
public class LoopPractice {

    public static void main(String[] args) {
        // 1) for: 반복 횟수가 정해져 있을 때
        int forSum = 0;
        for (int i = 1; i <= 100; i++) {
            forSum += i;
        }

        // 2) while: 조건이 참인 동안 반복 (변수 초기화·증가를 직접 관리)
        int whileSum = 0;
        int n = 1;
        while (n <= 100) {
            whileSum += n;
            n++;
        }

        int formula = 100 * (100 + 1) / 2; // 검증용 공식 n(n+1)/2

        System.out.println("=== 1~100 합계 ===");
        System.out.println("for   합계 = " + forSum);
        System.out.println("while 합계 = " + whileSum);
        System.out.println("공식 n(n+1)/2 = " + formula + (forSum == formula && whileSum == formula ? " (일치)" : " (불일치)"));

        // 3) 중첩 for: 바깥 반복 = 단(2~9), 안쪽 반복 = 곱하는 수(1~9)
        System.out.println();
        System.out.println("=== 구구단 2~9단 ===");
        int lines = 0;
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("[" + dan + "단]");
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d x %d = %2d%n", dan, i, dan * i);
                lines++;
            }
        }

        System.out.println();
        System.out.println("합계=" + forSum + ", 2단~9단 정상 출력 (" + lines + "줄)");
    }
}
