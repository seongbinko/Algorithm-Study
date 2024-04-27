package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {

    /*
    입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력한다.
    10 5 // 온도를 측정한 날짜 수, 합을 구하기 위한 연속적인 날짜의 수
    3 -2 -4 -9 0 3 7 13 8 -3 //매일 측정한 온도
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //누적합 배열 만들기
        int[] temperatures = new int[N]; //    3, -2, -4, -9,    0,  3,  7, 13,  8, -3
        int[] prefix = new int[N+1];     //0,  3,  1, -3, -12, -12, -9, -2, 11, 19, 16
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             temperatures[i] = Integer.parseInt(st.nextToken());
             prefix[i+1] = prefix[i] + temperatures[i];
        }

        //K 간격에서 최대값 구하기
        int max = Integer.MIN_VALUE;
        for (int i = K; i < N+1; i++) {
            int gap = prefix[i] - prefix[i - K]; //prefix[2] - prefix[0]
            if(max < gap){
                max = gap;
            }
        }

        System.out.println(max);


    }

    /*

    1+2,
    1+2+3,
    1+2+3+4

    일련의 과정을 최적화 하는 방법 : 누적합 계산해두기

    1+2,
    3+3,
    6+4

    * */

}
