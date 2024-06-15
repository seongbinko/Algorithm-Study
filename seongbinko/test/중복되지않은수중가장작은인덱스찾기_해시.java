package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 중복되지않은수중가장작은인덱스찾기_해시 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i)); // pwwkew k
            int[] countAndIndex = map.getOrDefault(ch, new int[]{0, Integer.MAX_VALUE});
            countAndIndex[0]++;
            countAndIndex[1] = Math.min(countAndIndex[1], i);
            map.put(ch, countAndIndex);
        }
        int answer = Integer.MAX_VALUE;
        for (String key : map.keySet()) {
            int[] countAndIndex = map.get(key);
            if (countAndIndex[0] == 1) {
                answer = Math.min(answer, countAndIndex[1]);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
