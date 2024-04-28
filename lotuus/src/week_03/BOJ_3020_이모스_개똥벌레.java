package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020_이모스_개똥벌레 {

    /*
    동굴의 길이는 N미터이고, 높이는 H미터이다. (N은 짝수)
    첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장
    석순은 아래에서 솟은 장애물, 종유석은 위에서 내려온 장애물
    개똥벌레가 파괴해야하는 장애물의 최솟값과 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //동굴의 길이
        int H = Integer.parseInt(st.nextToken()); //동굴의 높이

        int[] block = new int[N];
        for (int i = 0; i < N; i++) {
            block[i] = Integer.parseInt(br.readLine()); //장애물의 크기
        }







    }
    /*
    이모스법
    장애물 시작부분에 1, 끝부분에 -1을 적고 누적합해주면 쉽게 구할 수 있다.
    * */

}
