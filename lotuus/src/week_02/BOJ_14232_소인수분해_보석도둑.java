package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14232_소인수분해_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        //무게 = 모든 보석들의 곱
        //들 수 있는 무게 N, 이때 보석들의 최대 개수

        //N을 2부터 sqrtN 까지 소인수분해하자
        int sqrtN = (int) Math.sqrt(N);
        int count = 0;
        StringBuilder sb = new StringBuilder();

        //N을 소인수분해 했을 때, 나타날 수 있는 인수 중에서 가장 큰 값은 루트 N
        for (int k = 2; k <= sqrtN; k++) {

            while(N % k == 0){
                N = N / k;
                count++;
                sb.append(k).append(" ");
            }

        }

        //15의 루트는 3.8XX 이기 때문에 3만 구해짐
        //나머지 5가 남은 상황. 5 추가
        if(N != 1){
            count++;
            sb.append(N);
        }

        System.out.println(count);
        System.out.println(sb);


    }
}
