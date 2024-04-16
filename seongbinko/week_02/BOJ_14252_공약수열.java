package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14252_공약수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            list.add(t);
        }
        list.sort(Comparator.naturalOrder());

        int answer = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Integer a = list.get(i);
            Integer b = list.get(i + 1);

            if (_gcd(a, b) == 1) {
                continue;
            }

            boolean oneMore = true;
            for (int j = a + 1; j < b; j++) {
                if (_gcd(a, j) == 1 && _gcd(j, b) == 1) {
                    answer++;
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
                            answer++;
                            list.add(k);
                            answer++;
                            stop = true;
                            break;
                        }
                    }
                    if (stop) {
                        break;
                    }
                }
            }
            list.sort(Comparator.naturalOrder());
        }
        System.out.println(answer);
    }

    public static long _gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
