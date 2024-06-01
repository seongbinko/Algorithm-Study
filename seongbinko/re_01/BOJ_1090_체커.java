package re_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1090_체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        Arrays.fill(answer, Integer.MAX_VALUE);
        List<int[]> inputs = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            inputs.add(new int[]{x, y});
            min = Math.min(min, x);
            min = Math.min(min, y);
            max = Math.max(max, x);
            max = Math.max(max, y);
        }
        // 메모리 초과, 범위를 max로 하면 안된다.
        for (int x = min; x <= max; x++) {
            for (int y = min; y <= max; y++) {
                // 해당 지점까지 걸리는 거리
                List<Integer> list = new ArrayList<>();
                for (int[] input : inputs) {
                    int a = input[0];
                    int b = input[1];

                    int xResult = Math.abs(x - a);
                    int yResult = Math.abs(y - b);
                    list.add(xResult + yResult);
                }
                // 거리가 적게 걸리는 순으로
                list.sort(Comparator.naturalOrder());
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i); // [1], [1,2], [1,2,3]
                    answer[i] = Math.min(answer[i], sum);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
    }
}
