package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_투포인터_두수의합 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 1 2 3 5 7 9 10 11 12
        int X = Integer.parseInt(br.readLine());

        int s = 0;
        int e = N - 1;
        while (s < e) {
            if (arr[s] + arr[e] == X) {
                answer++;
                s += 1;
                e -= 1;
                continue;
            }
            if (arr[s] + arr[e] > X) {
                e -= 1;
            }
            if (arr[s] + arr[e] < X) {
                s += 1;
            }
        }
        System.out.println(answer);
    }
}
