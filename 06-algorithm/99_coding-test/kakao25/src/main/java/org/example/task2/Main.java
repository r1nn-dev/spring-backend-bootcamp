package org.example.task2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main { // 테스트
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Solution1 sol = new Solution1();

        System.out.println(sol.solution(2, "1A 2F 1C"));              // 2
        System.out.println(sol.solution(1, ""));                     // 2
        System.out.println(sol.solution(22, "1A 3C 2B 20G 5A"));     // 41

    }
}