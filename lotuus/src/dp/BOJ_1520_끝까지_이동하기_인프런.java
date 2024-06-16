package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_끝까지_이동하기_인프런 {

    /* 조건
     * 세로의 크기 M과 가로의 크기 N 지도
     * 각 칸에는 그 지점의 높이가 쓰여 있으며,
     * 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
     *
     * 결과
     * 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
     */


    static int m;
    static int n;
    static int[][] ground;
    static int[][] dp; // dp[y, x] = max(해당 좌표에서 이동할 수 있는 칸의 수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ground = new int[m][n];
        for (int y = 0; y < m; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                 ground[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        //0, 0에서 m, n으로 내려간다.
        System.out.println(move(0, 0));

    }

    static int[][] distance = new int[][]{
            {1, 0}, //상
            {-1, 0}, //하
            {0, -1}, //좌
            {0, 1} //우
    };

    private static int move(int y, int x) {

        //도착지에 도착했다면, 경로를 1개 찾은 것이므로
        if(y == m-1 && x == n-1){
            return 1;
        }

        if(dp[y][x] != -1){ //탐색한 곳이라면
            return dp[y][x];
        }

        //탐색 안한 곳이라면
        //상하좌우 이동
        int route = 0;
        for (int i = 0; i < distance.length; i++) {
            int dy = y + distance[i][0];
            int dx = x + distance[i][1];

            //좌표평면 벗어나면 안됨. 탐색불가
            if(dy < 0 || dy >= m || dx < 0 || dx >= n){
                continue;
            }

            //이동 전 높이 > 이동 후 높이 이어야 이동 가능
            if(ground[y][x] > ground[dy][dx]){
                route = route + move(dy, dx);
            }
        }

        dp[y][x] = route;

        return dp[y][x];
    }


}

/* 테스트

4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

* */