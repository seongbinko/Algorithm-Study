package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //집의 수

        int[][] rgb = new int[n][3]; //i번째 집일 때 집을 칠하는 최소 비용

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        //옆 친구와 같은 색을 가지지 않아야한다
        //집별로, 색깔별로 칠하는 비용을 더한다
        for (int i = 1; i < n; i++) {
            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + rgb[i][0];
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + rgb[i][1];
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + rgb[i][2];
        }

        //1번집을 빨간색으로 칠하는 경우
            //2번집을 초록/파랑으로 칠하는 경우 중, 최소값
            //만약 초록색이라면
                //3번집을 빨강/파랑으로 칠하는 경우 중, 최소값

        int min = Math.min(rgb[n - 1][0], rgb[n - 1][1]);
        min = Math.min(min, rgb[n - 1][2]);

        System.out.println(min);
    }

}