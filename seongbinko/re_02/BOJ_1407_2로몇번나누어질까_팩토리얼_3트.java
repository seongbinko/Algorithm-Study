package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1407_2로몇번나누어질까_팩토리얼_3트 {
    /**
     * 팩토리얼, 10! 이라 했을때, 2로 나눠가면서 2가 몇개 포함되어있는지를 알수있다.
     * 10//2=5  10//4=2.xxx 10//8 1.xxx 5+2+1 8개
     * <p>
     * 함수의 정의
     * 1 1 1 1 1 1 1 1 1 1 2^0 1은 모두 포함하니 더해줬다고 가정
     * 10//2^1 * 2^1 - 2^0
     * 10//2^2 * 2^2 - 2^1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken()); //5
        long b = Long.parseLong(st.nextToken()); //9

        int digit = Integer.parseInt(st.nextToken());
        long answer = func(b, digit) - func(a - 1, digit);

        System.out.println(answer);

    }

    private static long func(long n, int digit) {
        long result = 0;
        result += n;
        for (int i = 1; i < 1000000; i++) {
            if (n / Math.pow(digit, i) < 1) {
                break;
            }
            long sum = (n / (long) Math.pow(digit, i) * ((long) Math.pow(digit, i) - (long) Math.pow(digit, i - 1)));
            result += sum;
        }
        return result;
    }
}
