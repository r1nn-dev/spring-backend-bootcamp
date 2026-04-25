package org.example;

public class Solution1 {
    public int solution(int N, String S) {
        // 줄 수 N, 예약 좌석 문자열 S(길이 M)
        // 예약된 좌석을 boolean 배열에 담는다.
        boolean[][] reserved = new boolean[N + 1][10];

        // 예약 좌석 문자열이 비어 있지 않은 경우에만 파싱한다.
        if (S != null && !S.isEmpty()) {
            // 예약 좌석 문자열을 공백 기준으로 나눈다.
            String[] fullSeat = S.split(" ");

            // 예약된 좌석을 하나씩 확인해서 배열에 표시한다.
            for (String seat : fullSeat) {
                // 좌석 문자열에서 마지막 문자는 열
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char colChar = seat.charAt(seat.length() - 1);
                // 좌석 문자를 배열 인덱스로 변환.
                int col = getColumnIndex(colChar);
                // 해당 좌석을 예약된 상태로 표시.
                reserved[row][col] = true;
            }
        }

        int answer = 0;

        // 각 줄마다 4인 가족을 최대 몇 팀 배치할 수 있는지 확인한다.
        for (int row = 1; row <= N; row++) {

            // 무조건 4인 가족
            // B C D E: 통로 기준 2명 / 2명으로 나뉘므로 가능
            // D E F G: 가운데 4좌석이 연속되어 있으므로 가능
            // F G H J: 통로 기준 2명 / 2명으로 나뉘므로 가능
            boolean left = isAvailable(reserved[row], 1, 4);   // B C D E
            boolean middle = isAvailable(reserved[row], 3, 6); // D E F G
            boolean right = isAvailable(reserved[row], 5, 8);  // F G H J

            // 한 줄에 2가족을 앉히려면 왼쪽 구간과 오른쪽 구간이 모두 비어 있어야 한다.
            // left와 right는 서로 겹치지 않는다.
            if (left && right) {
                answer += 2;
            }

            // left와 right를 동시에 쓸 수 없다면,
            // left, middle, right 중 하나라도 가능할 때 1가족을 앉힐 수 있다.
            else if (left || middle || right) {
                answer += 1;
            }
        }
        return answer;
    }

    // 좌석 문자를 배열 인덱스로 변환한다.
    // A B C D E F G H J K
    // 0 1 2 3 4 5 6 7 8 9
    private int getColumnIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            case 'G': return 6;
            case 'H': return 7;
            case 'J': return 8;
            case 'K': return 9;
        }
        return -1;
    }

    // start부터 end까지의 좌석이 모두 비어 있는지 확인한다.
    // 하나라도 예약되어 있으면 해당 구간에는 가족을 앉힐 수 없다.
    private boolean isAvailable(boolean[] row, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (row[i]) {
                return false;
            }
        }
        return true;
    }
}
