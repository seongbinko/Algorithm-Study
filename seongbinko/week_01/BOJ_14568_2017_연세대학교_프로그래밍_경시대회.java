package week_01;

import java.io.*;

public class BOJ_14568_2017_연세대학교_프로그래밍_경시대회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int a = 1; a < n + 1; a++) {
            for (int b = 1; b < n + 1; b++) {
                for (int c = 1; c < n + 1; c++) {
                    if (a + b + c == n && a >= b + 2 && c % 2 == 0) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
