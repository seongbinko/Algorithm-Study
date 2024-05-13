package psg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PSG_K진수에서소수개수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    private static int solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % k);
            n /= k;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            System.out.print(list.get(i));
        }
        System.out.println();
        String[] split = sb.toString().split("0");

        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            // 소수 찾기
            boolean result = true;
            if (split[i].equals("") || split[i].equals("1")) {
                continue;
            }
            long value = Long.parseLong(split[i]);
            for (int j = 2; j <= Math.sqrt(value); j++) {
                if (value % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result) {
                answer++;
            }
        }
        return answer;
    }
}
