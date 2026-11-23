import java.util.Arrays;
import java.util.Scanner;

/**
 * 4-5 배열과 정렬 실습
 * 정수 5개를 반복문으로 입력받아 배열에 저장하고, 원본과 오름차순 정렬 결과를 출력한다.
 * 정렬은 버블 정렬을 직접 구현하고, Arrays.sort() 결과와 같은지 확인한다.
 */
public class ArraySort {

    private static final int SIZE = 5;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = new int[SIZE];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = readInt(scanner, (i + 1) + "번째 정수를 입력하세요: ");
            }

            // 원본을 보존하려고 복사본을 정렬한다 (배열은 참조라 그대로 정렬하면 원본이 바뀜)
            int[] sorted = numbers.clone();
            bubbleSort(sorted);

            int[] library = Arrays.copyOf(numbers, numbers.length);
            Arrays.sort(library);

            System.out.println();
            System.out.println("입력 배열      : " + Arrays.toString(numbers));
            System.out.println("버블 정렬      : " + Arrays.toString(sorted));
            System.out.println("Arrays.sort()  : " + Arrays.toString(library)
                    + (Arrays.equals(sorted, library) ? " (일치)" : " (불일치)"));
            System.out.println("입력값 " + Arrays.toString(numbers) + " → 정렬 후 " + Arrays.toString(sorted));
        }
    }

    /**
     * 버블 정렬 (오름차순): 이웃한 두 값을 비교해 큰 값을 뒤로 보낸다.
     * 한 바퀴 돌 때마다 가장 큰 값이 맨 뒤에 고정되므로 비교 범위를 하나씩 줄인다.
     * 한 바퀴 동안 교환이 없으면 이미 정렬된 것이므로 멈춘다.
     */
    static void bubbleSort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
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
