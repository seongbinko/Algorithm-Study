package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2436_공약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());

        long xy = gcd * lcm;  // xy 두수의 곱

        // 임의의 어떤 수 x,y를 알아야함
        long sum = Long.MAX_VALUE;
        long a = 0;
        long b = 0;
        for (long x = gcd; x < Math.sqrt(xy) + 1; x += gcd) { // 절반만 탐색해도 됨 (6*30 == 30*6)
            long y = xy / x;  // x와 y는 xy 값을 벗어 날 수는 없으며 간격을 줄이면서 적절한 값을 찾아야한다.
            if (_gcd(x, y) == gcd) {
                if (_lcm(x, y) == lcm) {
                    if (sum > x + y) {
                        sum = x + y;
                        a = x;
                        b = y;
                    }
                }
            }
        }
        System.out.printf("%d %d%n", a, b);
    }


    /**
     * a >= b
     */
    public static long _gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static long _lcm(long a, long b) {
        return a * b / _gcd(a, b);
    }
}
