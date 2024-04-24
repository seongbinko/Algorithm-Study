package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arrs = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrs[i][0] = Integer.parseInt(st.nextToken());
            arrs[i][1] = Integer.parseInt(st.nextToken());
            arrs[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    boolean[] booleans = new boolean[N];
                    // i=1 j=2 k=3  // 정답이어야 할 수
                    for (int l = 0; l < N; l++) {
                        // 내가 찍은수
                        int[] num = Arrays.stream((arrs[l][0] + "")
                                .split(""))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        int strike = arrs[l][1];
                        int ball = arrs[l][2];

                        int st = 0;
                        int ba = 0;
                        if (num[0] == i) {
                            st++;
                        }
                        if (num[1] == i) {
                            ba++;
                        }
                        if (num[2] == i) {
                            ba++;
                        }

                        if (num[0] == j) {
                            ba++;
                        }
                        if (num[1] == j) {
                            st++;
                        }
                        if (num[2] == j) {
                            ba++;
                        }

                        if (num[0] == k) {
                            ba++;
                        }
                        if (num[1] == k) {
                            ba++;
                        }
                        if (num[2] == k) {
                            st++;
                        }

                        if (strike == st && ball == ba) {
                            booleans[l] = true;
                        }
                    }

                    boolean allTrue = true;
                    for (boolean aBoolean : booleans) {
                        if (!aBoolean) {
                            allTrue = false;
                        }
                    }
                    if (allTrue) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
