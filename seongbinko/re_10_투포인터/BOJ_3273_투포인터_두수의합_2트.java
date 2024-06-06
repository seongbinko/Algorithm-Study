package re_10_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_투포인터_두수의합_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);
        // 1 2 3 5 7 9 10 11 12
        int X = Integer.parseInt(br.readLine());
        // input[i] + input[j] = X를 만족하는 쌍의 갯수
        int answer = 0;
        int s = 0;
        int e = N - 1;

        // 1. X를 만족
        // 2. X보다 클경우 -> end 왼쪽 한칸이동
        // 3. X보다 작을 경우 -> start를 오른쪽 한칸이동
        while (s < e) {
            if (inputs[s] + inputs[e] == X) {
                s += 1;
                e -= 1;
                answer++;
                continue;
            }
            if (inputs[s] + inputs[e] > X) {
                e -= 1;
                continue;
            }
            if (inputs[s] + inputs[e] < X) {
                s += 1;
            }
        }
        System.out.println(answer);
    }
}
