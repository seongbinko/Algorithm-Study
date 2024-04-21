package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1978_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sqrtN = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrtN; i++) {
            if(N % i == 0){
                System.out.println(i +" "+ N/i); //약수
            }
        }

    }

    /*
    숫자 N의 약수, 약수의 개수를 출력

    방법 1
    1부터 N까지 나누어 떨어 지는지 확인

    코드
    for (int i = 1; i <= N; i++) {
        if(N % i == 0){
            System.out.println(i); //약수!
        }
    }

    ---------------------------------------------

    방법 2
    1부터 루트 N까지 나누어 떨어 지는지 확인 (수학적으로 증명된 결과)

    예시
    N = 16
    1 * 16 == 1 * (16/1)
    2 * 8 == 2 * (16/2)
    4 * 4 == 4 * (16/4)

    N = 18
    1 * 18 == 1 * (18/1)
    2 * 9 == 2 * (18/2)
    3 * 6 == 3 * (18/3)

    코드
    int sqrtN = (int) Math.sqrt(N);
    for (int i = 1; i <= sqrtN; i++) {
        if(N % i == 0){
            System.out.println(i +" "+ N/i); //약수
        }
    }

    ---------------------------------------------

    * */

}
