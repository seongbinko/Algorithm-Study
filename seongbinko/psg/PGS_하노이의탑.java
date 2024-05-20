package psg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_하노이의탑 {
    public static void main(String[] args) {
        PGS_하노이의탑 method = new PGS_하노이의탑();
        int n = 1;
        int[][] solution = method.solution(n);
        // 스트림을 사용한 배열 출력
        Arrays.stream(solution)
                .map(row -> Arrays.stream(row)
                        .mapToObj(Integer::toString)
                        .reduce((a, b) -> a + " " + b)
                        .orElse(""))
                .forEach(System.out::println);
    }

    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        // return arr.stream().toArray(i -> new int[i][i]); 하면 메모리 초과
        return arr.stream().toArray(int[][]::new);
    }

    private static List<int[]> arr = new ArrayList<>();

    private static void hanoi(int n, int start, int end) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, start, 6 - start - end);
        arr.add(new int[]{start, end});
        hanoi(n - 1, 6 - start - end, end);

    }
}
