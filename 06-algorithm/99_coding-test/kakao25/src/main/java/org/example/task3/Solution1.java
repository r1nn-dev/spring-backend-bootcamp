package org.example.task3;

public class Solution1 {
    public int solution(int[] T, int[] A) {
        // 트리

        // T 배열의 길이: 전체 스킬 개수 N
        boolean[] learned = new boolean[T.length];
        // 실제로 새로 배워야 하는 스킬 개수
        int answer = 0;

        // A 배열: 최종적으로 배우고 싶은 목표 스킬들.
        for (int targetSkill : A) {
            // 현재 목표 스킬에서 시작해서 부모 방향으로 거슬러 올라간다.
            int currentSkill = targetSkill;
            // 아직 배우지 않은 스킬을 만나는 동안 계속 부모로 올라간다.
            while (!learned[currentSkill]) {
                // 현재 스킬을 새로 배운다.
                learned[currentSkill] = true;
                answer++;
                // 루트 스킬 0에 도착하면 더 이상 위로 올라갈 필요가 없다.
                if (currentSkill == 0) {
                    break;
                }
                // 현재 스킬을 배우기 위해 필요한 부모 스킬로 이동한다.
                // 예: T[6] = 3 이면 6번 스킬의 부모는 3번 스킬이다.
                currentSkill = T[currentSkill];
            }

            // while이 끝나는 경우.
            // 1. 루트 0까지 올라가서 필요한 스킬을 모두 배운 경우
            // 2. 이미 배운 스킬을 만나서 더 올라갈 필요가 없는 경우
        }

        return answer;

    }
}
