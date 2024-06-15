package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 중복되지않은수중가장작은인덱스찾기_IndexOf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 글자 카운트된 수를 기억하고 있는다.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 글자 카운트 확인하여 1번만 나온 것이 중복되지 않은 문자.
        List<String> strList = new ArrayList<>();
        for (String key : map.keySet()) {
            Integer cnt = map.get(key);
            if (cnt == 1) {
                strList.add(key);
            }
        }

        // 1번만 나온것이 존재하지 않는다.
        if (strList.isEmpty()) {
            System.out.println(-1);
        } else {
            int min = Integer.MAX_VALUE;
            for (String str : strList) {
                min = Math.min(min, input.indexOf(str));
            }
            System.out.println(min);
        }
    }
}
