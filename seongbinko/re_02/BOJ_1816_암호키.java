package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1816_암호키 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] answer = new String[N];
        Arrays.fill(answer, "YES");

        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());

            for (int j = 2; j <= 1000000; j++) {
                if (input % j == 0) {
                    answer[i] = "NO";
                    break;
                }
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
