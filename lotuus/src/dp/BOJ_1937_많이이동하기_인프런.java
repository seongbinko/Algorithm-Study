package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_많이이동하기_인프런 {

    /* 조건
     * n × n의 크기의 대나무 숲이 있다.
     * 판다는 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다.
     * 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.
     *
     * 결과
     * n × n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지 구하여라.
     */


    static int n;
    static int[][] ground;
    static int[][] dp; // dp[y, x] = max(해당 좌표에서 이동할 수 있는 칸의 수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ground = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                 ground[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }


        //모든 칸에서 얼만큼 이동할 수 있는지 구하자.
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                moveAndGetDistance(y, x);
            }
        }

        //최대값 구하기
        int max = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                max = Math.max(max, dp[y][x]);
            }
        }

        System.out.println(max+1);

    }

    static int[][] distance = new int[][]{
            {1, 0}, //상
            {-1, 0}, //하
            {0, -1}, //좌
            {0, 1} //우
    };

    private static int moveAndGetDistance(int y, int x) {

        if(dp[y][x] != -1){ //탐색한 곳이라면
            return dp[y][x];
        }

        //탐색 안한 곳이라면
        //상하좌우 이동
        int point = 0;
        for (int i = 0; i < distance.length; i++) {
            int dy = y + distance[i][0];
            int dx = x + distance[i][1];

            //좌표평면 벗어나면 안됨. 탐색불가
            if(dy < 0 || dy >= n || dx < 0 || dx >= n){
                continue;
            }

            //이동 전 <= 이동 후 대나무가 더 많이 있어야 이동 가능하다
            if(ground[y][x] <= ground[dy][dx]){
                point = Math.max(point, moveAndGetDistance(dy, dx)+1 );
                // +1의 의미 : 다음 좌표로 이동했으니 이동거리인 +1을 추가한다
            }
        }

        dp[y][x] = point;
        return dp[y][x];
    }


}

/* 테스트

4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8

* */