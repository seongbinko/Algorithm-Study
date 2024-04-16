package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_14232_보석_도둑 {
    // 첫째 줄에는 효빈이가 들 수 있는 무게 k가 주어진다.(2≤k≤10^12)
    // 수가 매우 크기 때문에 루트가 필요하다 생각, 10^6
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        List<Long> list = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                list.add(i);
                N = N / i;
            }
        }
        if (N != 1) {
            list.add(N);
        }
        System.out.println(list.size());
        System.out.println(list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
