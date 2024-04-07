package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1090_체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Y와 X를 입력받고 For 문을 돈다면 해당 공간을 만든 것이므로 Input 추가적으로 필요
        List<Integer> X = new ArrayList<>(); // 집들이 만날 X 축
        List<Integer> Y = new ArrayList<>(); // 집들이 만날 Y 추

        List<List<Integer>> XY = new ArrayList<>(); // 집들이 위치해 있는곳
        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            X.add(x);
            Y.add(y);
            XY.add(Arrays.asList(x, y));
        }

        int[] answer = new int[N];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (Integer y : Y) {
            for (Integer x : X) {
                // 각각의 점들이 x,y로 모이는 비용들의 배열
                List<Integer> dist = new ArrayList<>(); // 0, 1, 2, 3
                for (List<Integer> xy : XY) {
                    // N개의 집이 해당장소로 오는 비용 구하기

                    Integer a = xy.get(0);
                    Integer b = xy.get(1);

                    int cost = Math.abs(y - b) + Math.abs(x - a);
                    dist.add(cost);
                }
                dist.sort(Comparator.naturalOrder());

                int sum = 0;
                for (int i = 0; i < dist.size(); i++) {
                    sum += dist.get(i); // 처음 1개 모일때, i가 증가 할수록 n개가 모일 때의 최소 거리 총합
                    answer[i] = Math.min(answer[i], sum);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
    }
}
