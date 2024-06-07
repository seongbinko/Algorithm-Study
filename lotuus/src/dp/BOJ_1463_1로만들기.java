package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1463_1로만들기 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n+1];

        for (int i = 2; i <= n; i++) {

            //n을 1로 뺴는 경우
            dp[i] = dp[i-1] + 1; //dp탐색할때마다 연산횟수 +1 추가

            //n이 3으로 나뉘는 경우
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }

            //n이 2로 나뉘는 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }

        }


        System.out.println(dp[n]);
    }



    /*
        - N이 3으로 나누어 떨어지면, 3으로 나눈 결과 저장, 아니라면 통과
        - N이 2로 나누어 떨어지면, 2으로 나눈 결과 저장, 아니라면 통과
        - 1을 뺀 결과 저장

        N=10
        | N/3 | N/2 | N-1 |
        | 패스 | 5   | 9   |
        => 연산 1번째, 결과 5, 9

        N=5
        | N/3 | N/2 | N-1 |
        | 페스 | 패스 | 4   |

        N=9
        | N/3 | N/2 | N-1 |
        | 3   | 패스 | 8   |
        => 연산 2번째, 결과 4, 3, 8

        N=4
        | N/3 | N/2 | N-1 |
        | 패스 | 2   | 3   |

        N=3
        | N/3 | N/2 | N-1 |
        | 1   |     |     |
        => 연산 3번쨰, 결과 1! 종료

        연산횟수에 대한 결과개수가 다양하게 나올 수 있을 것 같다.
        재귀로 연산 결과마다 3가지 연산을 비교하는게 좋을 것 같다.
    * */


    /* 추가
        탐색한 N에 대한 결과값을 저장해두면 좋을듯
        N=9에서도 3이 나오고, N=4에서도 3이 나온다.

        N=3에서 1을 만들려면
        -1 3번도 있지만
        N/3 1번만 하면 1을 만들 수 있다 << 최소연산
        dp[N] = 최소연산값
        dp[3] = 1

        dp[2] = 1
        dp[3] = 1
        dp[4] = (dp[2]+1, -1-1-1-1) = 2
        dp[5] = 4

        탑다운보단 바텀업이 더 생각하기 쉬울거같아서 바텀업으로 구현하였다.
    * */

}