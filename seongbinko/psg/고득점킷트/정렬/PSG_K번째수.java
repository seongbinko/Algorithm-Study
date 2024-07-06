package psg.고득점킷트.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PSG_K번째수 {

    public static void main(String[] args) {
        PSG_K번째수 psgK번째수 = new PSG_K번째수();
        int[] solution = psgK번째수.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;

            List<Integer> list = new ArrayList<>();
            // 원하는 수 담기
            for (int j = start; j <= end; j++) {
                list.add(array[j]);
            }
            // 오름차순 정렬
            list.sort(Comparator.comparing(Integer::intValue));

            int k = commands[i][2] - 1; // k번째 수
            answer[i] = list.get(k);
        }

        return answer;
    }
}
