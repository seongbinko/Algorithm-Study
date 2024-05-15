package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22988_투포인터_재활용캠페인 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken()); // 용량

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        int remain = 0;
        int s = 0;
        int e = N - 1;

        double D = (double) X / 2.0;
        while (s <= e) {
            if (arr[e] == X) {
                count++;
                e -= 1;
                continue;
            }
            // 이 조건이 먼저 시작되어야함
            if (s == e) {
                remain++;
                break;
            }
            if (arr[e] + arr[s] >= D) {
                count++;
                s += 1;
                e -= 1;
                continue;
            }
            if (arr[e] + arr[s] < D) {
                s += 1;
                remain++;
            }
        }
        System.out.println(count + remain / 3);
    }
}
