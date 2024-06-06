package re_07_점화식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_피보나치_점화식_2트 {

    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        inputs = new int[N + 1];
        inputs[0] = 1;
        inputs[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            inputs[i] = (inputs[i - 1] + inputs[i - 2]) % 10007;
        }
        System.out.println(inputs[N]);
    }
}
