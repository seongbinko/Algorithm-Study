package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복되지않은수중가장작은인덱스찾기_완전탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = -1;
        // welcome
        for (int i = 0; i < input.length(); i++) {
            boolean flag = true;
            char ch1 = input.charAt(i); // 중복되지 않아야 하는 문자열
            for (int j = i + 1; j < input.length(); j++) {
                char ch2 = input.charAt(j);
                // 처음이 중복되지 않은 수열일 경우가 존재
                // 같은 문자가 존재한다.
                // 중복이다.
                if (ch1 == ch2) {
                    flag = false;
                    break;
                }
            }
            // 시간복잡도 개선
            // 완전탐색 -> 최적화 -> 기억 ->

            // 만약 flag가 true라면 해당 문자는 중복되지 않는 문자이다.
            if (flag) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
