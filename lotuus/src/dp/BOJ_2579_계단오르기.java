package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {
    //https://www.acmicpc.net/problem/2579

    static int count;
    static int stair[];
    static int dp[]; //각 계단에서 가질 수 있는 최대값을 저장한다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        stair = new int[count+1];
        dp = new int[count+1];

        Arrays.fill(dp, -1);

        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        recur(count);
        //마지막 계단을 반드시 밟아야한다.

        System.out.println(dp[count]);
    }

    private static int recur(int stairIndex) {

        //재귀 탈출
        if(stairIndex <= 3){
            return stair[stairIndex];
        }


        //기본동작
        if(dp[stairIndex] == -1){
            dp[stairIndex] = Math.max(
                    recur(stairIndex-1) + recur(stairIndex-3),
                    recur(stairIndex-2)
            ) + stair[stairIndex];
        }

        return dp[stairIndex];
    }




    /* 문제풀이

    다음 계단을 밟을 경우, 안밟을 경우 모든 경우의 수를 따져서 최대값을 구해야한다.

    계단의 개수는 300 이하이다.
    => 시간복잡도 : 다음 계단을 밟/안밟는 경우 2가지 O(2) * 계단의 개수 300번 O(N)

    6
    100
    40
    10
    60
    70
    20
    (220)

    //N번째에 올 수 있는 경우는 2가지 이다
        //N-1번째에서 1칸 올라오기
            //N-3번째에서 올라와야만 한다.
        //N-2번째에서 2칸 올라오기


    * */

}