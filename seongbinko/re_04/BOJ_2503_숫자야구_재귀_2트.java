package re_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구_재귀_2트 {
    static int N;
    static List<int[]> inputs = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        play(0, 111);
        System.out.println(answer);
    }

    private static void play(int hint, int number) {
        // 어떤 제약 조건
        // 1. 1000보다 작아야함
        if (number == 1000) {
            return;
        }
        // 2. 수가 서로 달라야함
        String[] numbers = String.valueOf(number).split("");
        if (!isPossibleNumber(numbers)) {
            play(0, number + 1);
            return;
        }

        // 종료 조건
        if (hint == N) {
            System.out.println(number + " ");
            answer++;
            // 다른 수가 있을 수도 있음
            play(0, number + 1);
            return;
        }
        // 재귀

        // 1. 힌트를 통과한 경우 -> 다음 힌트 진행
        if (passHint(inputs.get(hint), numbers)) {
            play(hint + 1, number);
        } else {
            // 2. 힌트를 통과하지 못한 경우 -> 힌트 초기화 다른 새로운 수로 바꾸기
            play(0, number + 1);
        }
    }

    private static boolean isPossibleNumber(String[] numbers) {
        if (numbers[0].equals("0")) {
            return false;
        }
        if (numbers[1].equals("0")) {
            return false;
        }
        if (numbers[2].equals("0")) {
            return false;
        }
        if (numbers[0].equals(numbers[1])) {
            return false;
        }
        if (numbers[1].equals(numbers[2])) {
            return false;
        }
        if (numbers[2].equals(numbers[0])) {
            return false;
        }
        return true;
    }

    private static boolean passHint(int[] exHints, String[] numbers) {

        int exNum = exHints[0];
        int exStrike = exHints[1];
        int exBall = exHints[2];

        int strike = 0;
        int ball = 0;
        String[] exNums = String.valueOf(exNum).split("");

        if (numbers[0].equals(exNums[0])) {
            strike++;
        }

        if (numbers[0].equals(exNums[1])) {
            ball++;
        }

        if (numbers[0].equals(exNums[2])) {
            ball++;
        }

        if (numbers[1].equals(exNums[1])) {
            strike++;
        }

        if (numbers[1].equals(exNums[2])) {
            ball++;
        }

        if (numbers[1].equals(exNums[0])) {
            ball++;
        }

        if (numbers[2].equals(exNums[2])) {
            strike++;
        }

        if (numbers[2].equals(exNums[0])) {
            ball++;
        }

        if (numbers[2].equals(exNums[1])) {
            ball++;
        }
        return ball == exBall && strike == exStrike;
    }
}
