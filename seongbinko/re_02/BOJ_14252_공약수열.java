package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14252_공약수열 {
    //    4
//    2200 42 2184 17
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 50 이하
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        int originSize = list.size();
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            Integer a = list.get(i);
            Integer b = list.get(i + 1);

            if (_gcd(a, b) == 1) {
                continue;
            }
            boolean oneMore = true;
            for (int j = a + 1; j < b; j++) {
                if (_gcd(a, j) == 1 && _gcd(j, b) == 1) {
                    list.add(j);
                    oneMore = false;
                    break;
                }

            }

            if (oneMore) {
                for (int j = a + 1; j < b; j++) {
                    boolean stop = false;
                    for (int k = j + 1; k < b; k++) {
                        if (_gcd(a, j) == 1 && _gcd(j, k) == 1 && _gcd(k, b) == 1) {
                            list.add(j);
                            list.add(k);
                            stop = true;

                            break;
                        }
                    }
                    if (stop) {
                        break;
                    }

                }
            }

            Collections.sort(list);
        }
        System.out.println(list.size() - originSize);

    }

    public static int _gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return _gcd(b, a % b);
    }
}
