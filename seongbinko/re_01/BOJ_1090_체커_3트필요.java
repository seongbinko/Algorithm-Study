package re_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1090_체커_3트필요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        Arrays.fill(answer, Integer.MAX_VALUE);
        List<int[]> inputs = new ArrayList<>();
        int[] X = new int[N];
        int[] Y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            inputs.add(new int[]{x, y});
            X[i] = x;
            Y[i] = y;

        }
        // 메모리 초과, 범위를 max로 하면 안된다.
        for (int x = 0; x < X.length; x++) {
            for (int y = 0; y < Y.length; y++) {
                // 해당 지점까지 걸리는 거리
                int x1 = X[x];
                int y1 = Y[y];
                List<Integer> list = new ArrayList<>();
                for (int[] input : inputs) {
                    int a = input[0];
                    int b = input[1];

                    int xResult = Math.abs(x1 - a);
                    int yResult = Math.abs(y1 - b);
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
