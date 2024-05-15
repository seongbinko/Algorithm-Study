package week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// StringBuilder 사용 유무 속도차이
// 3636ms -> 1308ms
// 메모리 156816 -> 107069
// 모두 통과는 되었음
public class BOJ_10815_이분탐색_숫자카드 {
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
        // -10 2 3 6 10

        int[] C = new int[m];

        for (int i = 0; i < m; i++) {
            int target = B[i];
            if (isaBoolean(A, target)) {
                C[i] = 1;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i : C) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean isaBoolean(int[] A, int target) {
        int s = 0;
        int e = A.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] > target) {
                e = mid - 1;
                continue;
            }
            if (A[mid] < target) {
                s = mid + 1;
                continue;
            }

        }
        return false;
    }
}
