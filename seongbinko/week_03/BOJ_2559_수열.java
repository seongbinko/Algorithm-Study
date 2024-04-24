package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 10
        int K = Integer.parseInt(st.nextToken()); // 2 간격

        int[] prefix = new int[N + 1];// [0,3,1,-3,-12,-12,-9,-2,11,19,16]
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + Integer.parseInt(st2.nextToken());
        }

        int[] answer = new int[N + 1];
        Arrays.fill(answer, -1000000); // 0이 가장 큰 값의 합이 될 수도 있기 때문
        for (int i = K; i < N + 1; i++) {
            answer[i] = prefix[i] - prefix[i - K];
        }
        System.out.print(Arrays.stream(answer).max().getAsInt());
    }
}
