package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {
    //https://www.acmicpc.net/problem/2579

    static int count;
    static int stair[];
    static boolean stairStep[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        stair = new int[count+2];
        stairStep = new boolean[count+2];
        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        int maxScore = 0;
//        stairStep[count] = true;

        for (int i = count; i >= 1; i--) {

            maxScore = maxScore + stair[i];
            stairStep[i] = true;

            if(stairStep[i+1] && stairStep[i]){
                i = i-1;
                continue;
            }

            if(i == 1){
                break;
            }

            if(stair[i - 1] >= stair[i - 2]){
                continue;
            }

            if(stair[i - 2] > stair[i - 1]){
                i = i-1;
                continue;
            }
        }

        System.out.println(maxScore);
    }




    /* 문제풀이

    다음 계단을 밟을 경우, 안밟을 경우 모든 경우의 수를 따져서 최대값을 구해야한다.

    계단의 개수는 300 이하이다.
    => 시간복잡도 : 다음 계단을 밟/안밟는 경우 2가지 O(2) * 계단의 개수 300번 O(N)

    0번째 계단에서 N번째 계단까지 올라가면서 점수를 계산하는 것보다
    N번째 계단을 어차피 반드시 밟아야하니, N번째에서 0번째 계단으로 내려오면서 점수를 비교하는게 더 좋을 것 같다.

    N번째에서
        N-1번쨰 계단의 점수와 N-2번째 계단의 점수를 비교해서 더 큰 값에 해당하는 계단으로 내려가고

    다음계단에서도 동일하게 진행하면 될 것 같다.

    ** 연속된 세개의 계단을 밟을 수 없다.
    6칸
    10 15 20 25 30 35 20
    이렇게 되면 N-1 vs N-2에서 무조건 N-1이 선택되어 한칸씩 내려가게된다

    ----------------------
    위 풀이의 반레
    6
    100
    40
    10
    60
    70
    20
    (220)


    * */

}