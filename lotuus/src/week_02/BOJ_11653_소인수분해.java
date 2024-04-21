package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653_소인수분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            return;
        }

        for (int k = 2; k <= N; k++) {

            while(N % k == 0){
                System.out.println(k);
                N = N / k;
            }

        }

    }

    /*
    소인수분해
    합성수를 소수의 곱으로 나타내는 것

    예시
    N = 72
    72 / 2 = 36
    36 / 2 = 18
    18 / 2 = 9
    9 / 2 (X)
    9 / 3 = 3
    3 / 2 (X)
    3 / 3 = 1

    N을 2부터 K까지 나누어보고
    나누어떨어지면 N을 N/K값으로 변경

    * */
}
