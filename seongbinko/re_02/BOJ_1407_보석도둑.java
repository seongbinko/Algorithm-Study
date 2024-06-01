package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1407_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken()); //5
        long b = Long.parseLong(st.nextToken()); //9
        List<Long> dp = new ArrayList<>();
        dp.add(0L);
        dp.add(1L);

        List<Long> list = new ArrayList<>();

        list.add(0L);
        list.add(1L);
        for (int i = 2; i <= b + 1; i++) {
            int count = 0;
            int j = i;
            while (j > 1) {
                if (j % 2 == 0) {
                    count++;
                    j = j / 2;
                } else {
                    break;
                }
            }
            long pow = (long) Math.pow(2, count);
            list.add(pow);
            long value = dp.get(dp.size() - 1) + pow;
            dp.add(value);
        }

        int answer = (int) (dp.get((int) b) - dp.get((int) a - 1));

        System.out.println(answer);

    }
}
