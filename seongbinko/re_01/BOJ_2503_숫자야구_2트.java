package re_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        List<int[]> answers = new ArrayList<>();
        List<String[]> guess = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            guess.add(str);
            answers.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int answer = 0;
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                for (int z = 1; z <= 9; z++) {
                    if (x != y && y != z && z != x) {

                        int count = 0;
                        for (int i = 0; i < N; i++) {
                            int exStrike = answers.get(i)[0];
                            int exBall = answers.get(i)[1];

                            int ball = 0;
                            int strike = 0;


                            int i1 = Integer.parseInt(guess.get(i)[0]);
                            int i2 = Integer.parseInt(guess.get(i)[1]);
                            int i3 = Integer.parseInt(guess.get(i)[2]);

                            // xyz <- 정답이라 생각되는 수
                            if (i1 == x) {
                                strike++;
                            } else if (i1 == y) {
                                ball++;
                            } else if (i1 == z) {
                                ball++;
                            }
                            //
                            if (i2 == x) {
                                ball++;
                            } else if (i2 == y) {
                                strike++;
                            } else if (i2 == z) {
                                ball++;
                            }
                            //
                            if (i3 == x) {
                                ball++;
                            } else if (i3 == y) {
                                ball++;
                            } else if (i3 == z) {
                                strike++;
                            }

                            if (strike == exStrike && ball == exBall) {
                                count++;
                            }
                        }
                        if (count == N) {
                            System.out.println(String.format("%d %d %d", x, y, z));
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
