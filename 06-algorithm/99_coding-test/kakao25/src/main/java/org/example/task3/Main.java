package org.example.task3;

public class Main { // 테스트
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        int[] T1 = {0, 0, 1, 1};
        int[] A1 = {2};
        System.out.println(sol.solution(T1, A1)); // 3

        int[] T2 = {0, 0, 0, 0, 2, 3, 3};
        int[] A2 = {2, 5, 6};
        System.out.println(sol.solution(T2, A2)); // 5

        int[] T3 = {0, 0, 1, 2};
        int[] A3 = {1, 2};
        System.out.println(sol.solution(T3, A3)); // 3

        int[] T4 = {0, 3, 0, 0, 5, 0, 5};
        int[] A4 = {4, 2, 6, 1, 0};
        System.out.println(sol.solution(T4, A4)); // 7

    }
}