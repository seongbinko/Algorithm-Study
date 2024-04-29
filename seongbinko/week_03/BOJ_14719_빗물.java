package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()); // 4
        int x = Integer.parseInt(st.nextToken()); // 8

        // 3,1,2,3,4,1,1,2
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[x];

        int sum = 0;
        int maxValue = 0;
        for (int i = 0; i < x; i++) {
            arr[i] = st.nextToken().charAt(0) - '0';
            sum += arr[i];
            maxValue = Math.max(maxValue, arr[i]);
        }

        int[] prefix = new int[x + 1];

        int preA = 0;
        int preAIndex = 0;
        for (int i = 0; i < x; i++) {
            if (preA < arr[i]) {
                prefix[i] = arr[i];
                preA = arr[i];
            } else {
                prefix[i] = preA;
            }
            if (preA == maxValue) {
                preAIndex = i;
                break;
            }
        }

        int preB = 0;
        int preBIndex = 0;

        for (int i = x - 1; i >= 0; i--) {
            if (preB < arr[i]) {
                prefix[i] = arr[i];
                preB = arr[i];
            } else {
                prefix[i] = preB;
            }
            if (preB == maxValue) {
                preBIndex = i;
                break;
            }
        }
        int result = Arrays.stream(prefix).sum() - sum;
        if (preA == preB) {
            int i = preBIndex - (preAIndex + 1) * maxValue;
            if (i > 0) {
                result += i;
            }
        }
        System.out.println(result);

    }
}
