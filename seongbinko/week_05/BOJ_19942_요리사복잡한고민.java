package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19942_요리사복잡한고민 {

    static int N;

    static List<Integer> minList = new ArrayList<>(); // 만족해야하는 최소 영양조건
    static List<int[]> list = new ArrayList<>();

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        minList.add(Integer.parseInt(st.nextToken()));
        minList.add(Integer.parseInt(st.nextToken()));
        minList.add(Integer.parseInt(st.nextToken()));
        minList.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < 1000; i++) {
            answer.add(9999);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c, d, e});
        }

        recur(0, 0, 0, 0, 0, 0, new boolean[N + 1]);

        for (int i = 0; i < answer.size(); i++) {
            if (i == 0) {
                if (answer.get(i) != 9999) {
                    System.out.println(answer.get(i));

                } else {
                    System.out.println(-1);
                    break;
                }
            } else if (answer.get(i) != 9999) {
                System.out.print(answer.get(i) + " ");
            }
        }

        // 출력
        // 1. 최소비용, 만족하는 조건이 없다면 -1
        // 2. 넣은 재료 번호
    }

//    6
//    100 70 90 10
//    30 55 10 8 100
//    60 10 10 2 70
//    10 80 50 0 50
//    40 30 30 8 60
//    60 10 70 2 120
//    20 70 50 4 4

    private static void recur(int index, int a, int b, int c, int d, int price, boolean[] used) {

        // 어디선가 꺼내서 최소비용을 만족하는지 확인해야한다.
        if (minList.get(0) <= a && minList.get(1) <= b && minList.get(2) <= c && minList.get(3) <= d) {
            // price 를 담는다.
            // 최소비용을 만족한다면 어딘가에 담는다.
            if (answer.get(0) > price) {
                answer.set(0, price);

                for (int i = 1; i < used.length; i++) {
                    if (used[i]) {
                        answer.set(i, i);
                    } else {
                        answer.set(i, 9999);
                    }
                }
            }
            return;
        }
        // N이 아니더라도 정답 조건에 만족하면 업데이트를해야 정답으로 인정이된다. 비용이 0 이라면,
        if (index == N) {
            return;
        }
        int[] arr = list.get(index); // index 번째의 재료 정보
        // 재료를 사용
        used[index + 1] = true;
        recur(index + 1, arr[0] + a, arr[1] + b, arr[2] + c, arr[3] + d, arr[4] + price, used);
        used[index + 1] = false;

        // 재료를 사용하지 않음
        recur(index + 1, a, b, c, d, price, used);

    }
}
