package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 10
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] prefix = new int[N+1];
        Arrays.fill(prefix, -1001);

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            prefix[i + 1] = Math.max(prefix[i] + n, n);
        }
        System.out.println(Arrays.stream(prefix).max().getAsInt());
    }
}
