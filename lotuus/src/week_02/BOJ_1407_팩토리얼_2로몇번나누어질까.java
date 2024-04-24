package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1407_팩토리얼_2로몇번나누어질까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //177! - 175!
        A = A-1;


        //찾아야할 숫자 N과, 숨어있는 숫자의 범위 A, B가 주어진다
        //A~B 에 포함된 숫자들 각각 N의 제곱수로 나누어지는 약수를 모두 찾고, 더해서 출력해라

        long resultB = B; //2^0 = 1인 경우
        for (int i = 1; i <= 50; i++) { //TODO 왜 50인지 모르겠다!! 왜냐면, 2^50 해야 주어진 조건의 10^15승 이상이 됨!
            long cnt = (long) (B / Math.pow(2, i));
            long change = (long) (Math.pow(2, i) - Math.pow(2, i - 1));
            resultB = resultB + (change * cnt);
        }

        long resultA = A;
        for (int i = 1; i <= 50; i++) {
            long cnt = (long) (A / Math.pow(2, i));
            long change = (long) (Math.pow(2, i) - Math.pow(2, i - 1));
            resultA = resultA + (change * cnt);
        }

        System.out.println(resultB - resultA);

    }

    /*
    팩토리얼

    20 팩토리얼에는 2가 몇번 곱해져 있을까? (개수)
    2의 제곱수로 20보다 작은 수까지 한번씩 나눈 다음
    그 수들을 전부 정수로 만들어서 더해주면 된다

    20 / 2^1(2) = 10
    20 / 2^2(4) = 5
    20 / 2^3(8) = 2.XX
    20 / 2^4(16) = 1.XX
    = 18개!

    8 팩토리얼에는 2의 제곱수가 얼마나 들어있을까?
         2^i                                1 2 3 4 5 6 7 8
    8 / (2^0=1) = 8    => 1은 8에 8개 들어있음 1 1 1 1 1 1 1 1
    8 / (2^1=2) = 4    => 2는 8에 4개 들어있음 1 2 1 2 1 2 1 2 << 위의 1 8개 중 4개를 2로 변경 8 + (1 * 4) = 12
    8 / (2^2=4) = 2    => 4는 8에 2개 들어있음 1 2 1 4 1 2 1 4 << 위의 2 4개 중 2개를 4로 변경 12 + (2 * 2) = 16
    8 / (2^3=8) = 1    => 8은 8에 1개 들어있음 1 2 1 4 1 2 1 8 << 위의 4 2개 중 1개를 8로 변경 16 + (4 * 1) = 20
    8 + 4 + 2 + 1 = 17개!

    * */
}
