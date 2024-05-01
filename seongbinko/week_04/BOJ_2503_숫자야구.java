package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구 {
    static int N;
    static int answer;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hint = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            list.add(new int[]{hint, strike, ball});
        }

        recur(100, 0);
        System.out.println(answer);
    }

    private static void recur(int number, int hintIndex) {
        // 탐색 종료
        if (number == 1000) {
            return;
        }

        char[] numCh = String.valueOf(number).toCharArray();
        // 서로 같은 수가 있거나, 0을 포함하고 있다면 return
        if (numCh[0] == numCh[1] || numCh[1] == numCh[2] || numCh[2] == numCh[0] || numCh[0] - '0' == 0 || numCh[1] - '0' == 0 || numCh[2] == 0 + '0') {
            recur(number + 1, 0);
            return;
        }

        // 처음에 힌트 카운트로 변수명이 작성되고, int[] hints = list.get(hintIndex); // [123, 1,1] 이부분이
        // for문 i < N, list.get(i)였다. 우리는 반복문이아니라 재귀를 도는 것이고, hintIndex 가 4에 도달한다는 의미는 끝까지 왔다는 의미이다.
        if (hintIndex == N) {
            answer++;
            //
            System.out.println("정답:" + number);
            // 1000까지는 반복이 되어야한다, 1번째 힌트가 부합하는 수를 찾아도 종료되어서는 안된다
            recur(number + 1, 0);
            // 더이상 진행을 못함 // 힌트를 전부 통과, 해당 재귀 종료
            return;
        }
        // number 100부터 시작
        int[] hints = list.get(hintIndex); // [123, 1,1]
        char[] hintChs = String.valueOf(hints[0]).toCharArray();
        int expectStrike = hints[1];
        int expectBall = hints[2];


        int actualStrike = 0;
        int actualBall = 0;


        if (numCh[0] == hintChs[0]) {
            actualStrike++;
        }
        if (numCh[1] == hintChs[1]) {
            actualStrike++;
        }
        if (numCh[2] == hintChs[2]) {
            actualStrike++;
        }

        if (numCh[0] == hintChs[1] || numCh[0] == hintChs[2]) {
            actualBall++;
        }
        if (numCh[1] == hintChs[0] || numCh[1] == hintChs[2]) {
            actualBall++;
        }
        if (numCh[2] == hintChs[0] || numCh[2] == hintChs[1]) {
            actualBall++;
        }
        // 스트라이크 카운트, 볼카운트가 동일 한 경우, 다음 힌트로 넘어간다.
        if (actualStrike == expectStrike && actualBall == expectBall) {
            recur(number, hintIndex + 1);
        } else {
            // 맞추지 못한 경우
            recur(number + 1, 0);
        }
    }
}
