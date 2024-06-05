package re_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912_끊어가는_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputs = new int[N];

        int[] prefix = new int[N + 1];
        Arrays.fill(prefix, -10001);
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if (prefix[i] + inputs[i] > inputs[i]) {
                prefix[i + 1] = prefix[i] + inputs[i];
            } else {
                prefix[i + 1] = inputs[i];
            }
        }
        System.out.println(Arrays.stream(prefix).max().getAsInt());
    }
}
