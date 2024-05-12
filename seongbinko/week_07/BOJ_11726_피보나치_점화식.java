package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_피보나치_점화식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007; // 미리 나누는 부분은 생각을 해봐야한다. 미리 나누더라도 문제는 없다.
        }
        System.out.println(arr[n]); // 미리 나누지 않고 답에서 나눈다면 에러 발생, 너무 큰수로 넘어감
    }
}
