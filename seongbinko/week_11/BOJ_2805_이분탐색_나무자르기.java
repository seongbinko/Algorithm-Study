package week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_이분탐색_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] forest = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            forest[i] = Integer.parseInt(st.nextToken());
        }

        // 10 15 17 20 정렬
        Arrays.sort(forest);
        int s = 0;
        int e = forest[N - 1]; // 20

        while (s <= e) {
            int H = (s + e) / 2;


            long wood = 0;
            for (int tree : forest) {
                if (tree > H) {
                    wood = wood + tree - H;
                }
            }
            if (wood == M) {
                e = H;
                break;
            }
            // 너무 H가 낮다
            if (wood > M) {
                s = H + 1;
                continue;
            }
            if (wood < M) {
                e = H - 1;
            }
        }
        System.out.println(e);
    }
}
