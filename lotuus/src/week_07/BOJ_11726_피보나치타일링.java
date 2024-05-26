package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11726_피보나치타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //블럭 개수

        //경우의 수
        //2**1 : 1가지
        //2**2 : =, || 2가지
        //2**3 : dp[1] + dp[2]  |=, =|, |||  3가지
        //2**4 : dp[3] + dp[2]  ||=, |=|, =||, ||||, ==  5가지

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        //n이 1000 가까이 되면 dp[n]의 값은 몇 백자리가 넘어가기 때문에 int 범위를 한참 넘어섭니다.
        //마지막에 10007로 나누는 것이 아니라 중간에 계산할 때에도 계속 10007로 나누어주어야 합니다.

        System.out.println(dp[n]);

    }

}