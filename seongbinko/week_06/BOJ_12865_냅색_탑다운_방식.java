package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 시간 초과, 완전 탐색으로는 풀지는 못함
 */
public class BOJ_12865_냅색_탑다운_방식 {
    static int n;
    static int W;
    static List<int[]> list = new ArrayList<>();
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물건 수
        W = Integer.parseInt(st.nextToken()); // 베낭 무게
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}); // weight, value
        }

        dp = new int[10000][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int answer = recur(0, 0);
        System.out.println(answer);
    }

    private static int recur(int index, int weight) {
        // W가 선행되지 않는다면, n 에 도달했을 때 무게가 큰 경우에는 잘못됨을 먼저 리턴을 하지 않기 때문에 문제가 발생
        if (weight > W) {
            return Integer.MIN_VALUE;
        }
        if (index == n) {
            return 0;
        }
        if (dp[weight][index] != -1) {
            return dp[weight][index];
        }
        int[] arr = list.get(index);// index = 0, arr = [6,13]
        // index = 1, arr = [4,8]
        // index = 2, arr = [3,6]
        // index = 3, arr = [5,12]

        int result = Math.max(recur(index + 1, weight + arr[0]) + arr[1], recur(index + 1, weight));

        dp[weight][index] = result; // dp[5][3] = 12
        // dp[weight][index] = value

        return dp[weight][index];

        // [0][3]에 12가 담긴다.
        // 배낭을 3번째 부터 시작해서 무게가 0임을 계산했을때 최대한으로 가질수 있는 가치는 얼마인가?
    }
}
