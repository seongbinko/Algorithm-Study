package re_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2559_2트_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 개수
        int k = Integer.parseInt(st.nextToken()); // 간격
        st = new StringTokenizer(br.readLine());

        // input은 정직하게 n으로 받기!
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + inputs[i];
        }
        int[] answers = new int[n + 1];
        Arrays.fill(answers, -10000000);
        for (int i = k; i < prefix.length; i++) {
            answers[i] = prefix[i] - prefix[i - k];
        }
        System.out.println(Arrays.stream(answers).max().getAsInt());
    }
}
