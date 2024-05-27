package re_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1816_암호_키_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long S = Long.parseLong(br.readLine());

            //소수 = 1과 자기 자신외에 나눠지는 것이 없는 수
            // 10 = 2 * 5
            // S = j * ?
            String result = "YES";
            for (long j = 2; j <= 1000000; j++) {
                if (S % j == 0) {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
