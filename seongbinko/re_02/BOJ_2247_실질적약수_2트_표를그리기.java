package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2247_실질적약수_2트_표를그리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = csod(N);
        System.out.println(answer % 1000000);
    }

    private static long csod(int n) {
        long sum = 0;
        for (int i = 2; i < n + 1; i++) {
            sum += (long) (n / i - 1) * i;
        }
        return sum;
    }
}
