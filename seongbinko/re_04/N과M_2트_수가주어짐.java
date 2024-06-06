package re_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_2트_수가주어짐 {
    static int N;
    static int M;
    static List<Integer> inputs = new ArrayList<>();
    static List<Integer> answers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs.add(Integer.parseInt(st.nextToken()));
        }
        inputs.sort(Comparator.naturalOrder());


        recur3(0);
        System.out.print(sb.toString());
    }

    //15656 수열에서는 | 1 | 2 | 3 | 세로선을 긋는 느낌
    private static void recur(int index) {
        if (index == M) {
            for (Integer answer : answers) {
                sb.append(answer + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < inputs.size(); i++) {
            answers.add(index, inputs.get(i));
            recur(index + 1);
            answers.remove(index);
        }
    }

    // 15655
    // 중복되는 수열
    // 9 9 금지
    // 1 8 / 8 1 금지
    private static void recur2(int index) {
        // index가 2면 크기가 2짜리 answer가 생겨져있을 것임
        if (index >= 2 && answers.get(index - 2) >= answers.get(index - 1)) {
            return;
        }

        if (index == M) {
            for (Integer answer : answers) {
                sb.append(answer + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < inputs.size(); i++) {
            answers.add(index, inputs.get(i));
            recur2(index + 1);
            answers.remove(index);
        }
    }

    // 15655
    // 중복되는 수열
    // 9 9 금지
    // 1 8 / 8 1 금지
    private static void recur3(int index) {
        // index가 2면 크기가 2짜리 answer가 생겨져있을 것임
        if (index >= 2 && answers.get(index - 2) == answers.get(index - 1)) {
            return;
        }

        if (index == M) {
            for (Integer answer : answers) {
                sb.append(answer + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < inputs.size(); i++) {
            answers.add(index, inputs.get(i));
            recur3(index + 1);
            answers.remove(index);
        }
    }
}