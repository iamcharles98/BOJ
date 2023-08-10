import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // 쿼리 실행 후 회전한 배열에 담겨있는 수 중 가장 작은 수를 answer에 담아서 반환 //
        map = makeArray(rows, columns);

        for (int curQuiry = 0; curQuiry < queries.length; curQuiry++) {
            answer[curQuiry] = getMinNumAfterTurn(queries[curQuiry], map);
        }

        return answer;
    }

    private int getMinNumAfterTurn(int[] query, int[][] map) {
        // 시계 방향으로 회전시킨다 + 가장 작은 숫자를 반환한다
        List<Integer> turnedList = new ArrayList<>();

        turnedList.add(map[query[0] - 1][query[1] - 1]);
        int height = Math.abs(query[0] - query[2]) + 1;
        int width = Math.abs(query[1] - query[3]) + 1;
        // 2 2 5 4 //
        // 2 2 3 3 //
        //위로 땡기기
        for (int row = query[0]; row < query[0] + height - 1; row++) {
            map[row - 1][query[1] - 1] = map[row][query[1] - 1];
            turnedList.add(map[row][query[1] - 1]);
        }
        //오른쪽에서 왼쪽으로 땡기기
        for (int col = query[1]; col < query[1] + width - 1; col++) {
            map[query[2] - 1][col - 1] = map[query[2] - 1][col];
            turnedList.add(map[query[2] - 1][col]);
        }
        //아래로 땡기기
        for (int row = query[2]; row > query[0]; row--) {
            map[row - 1][query[3] - 1] = map[row - 2][query[3] - 1];
            turnedList.add(map[row - 2][query[3] - 1]);
        }
        // 왼쪽에서 오른쪽으로 땡기기
        for (int col = query[3]; col > query[1]; col--) {
            map[query[0] - 1][col - 1] = map[query[0] - 1][col - 2];
            turnedList.add(map[query[0] - 1][col - 2]);
        }
        map[query[0] - 1][query[1]] = turnedList.get(0);

        // System.out.println(turnedList.toString());
        return Collections.min(turnedList);
    }

    private static int[][] makeArray(int row, int col) {
        int[][] array = new int[row][col];
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = count++;
            }
        }
        return array;
    }
}