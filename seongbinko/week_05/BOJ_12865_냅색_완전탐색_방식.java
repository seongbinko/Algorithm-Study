package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 시간 초과, 완전 탐색으로는 풀지는 못함
 */
public class BOJ_12865_냅색_완전탐색_방식 {
    static int A;
    static int B;
    static List<int[]> list = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 물건 수
        B = Integer.parseInt(st.nextToken()); // 베낭 무게

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        recur(0, 0, 0);
        System.out.println(answer);
    }

    private static void recur(int index, int weight, int value) {
        if (index == A) {
            answer = Math.max(answer, value);
            return;
        }
        int[] arr = list.get(index);
        // 베낭에 담는다
        if (B >= weight + arr[0]) {
            recur(index + 1, weight + arr[0], value + arr[1]);
        }
        // 베낭에 담지 않는다.
        recur(index + 1, weight, value);
    }
}
