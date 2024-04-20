package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1407_2로_몇_번_나누어질까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long answer = func(M) - func(N - 1);
        System.out.println(answer);
    }

    private static long func(long m) {
        long answer = m;
        for (int i = 1; i < 50; i++) {
            long sum = (m / (long) Math.pow(2, i)) * ((long) Math.pow(2, i) - (long) Math.pow(2, i - 1));
            answer += sum;
        }
        return answer;
    }
}
