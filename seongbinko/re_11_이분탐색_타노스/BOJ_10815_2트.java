package re_11_이분탐색_타노스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            // A에 B[i] 가 있는지 찾기, 이분탐색으로!

            int target = B[i];
            int s = 0;
            int e = n - 1;

            boolean result = false;
            while (s <= e) {
                int mid = (s + e) / 2;

                if (target == A[mid]) {
                    result = true;
                    break;
                }
                if (target > A[mid]) {
                    s = mid + 1;
                    continue;
                }
                if (target < A[mid]) {
                    e = mid - 1;
                }
            }
            if (result) {
                sb.append("1 ");

            } else {
                sb.append("0 ");

            }
        }
        System.out.println(sb.toString());
    }

}
