package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095_123더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j <= 11; j++) {
            dp[j] = dp[j-1] //3의 경우의 수에 +1만 해주면 되고
                    + dp[j-2] //2의 경우의 수에 +2만 해주면 되고
                    + dp[j-3]; //1의 경우의 수에 +3만 해주면 된다
        }


        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(dp[n]);
        }


    }


    /*
    모든 경우의 수를 돌면서 방법의 수를 계산해야한다.
    탑다운
    1
        1
            1
            2
            3
        2
            1
            2
            3
        3


    바텀업

    1을 만드는 경우에 3을 더해주고,
    2를 만드는 경우에 2를 더해주고,
    3을 만드는 경우에 1을 더해주면 4가 된다.

    * */

}