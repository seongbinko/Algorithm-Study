package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_요리사의고민 {

    static int N;
    static int[][] ingredient;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ingredient = new int[N][2];

        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            ingredient[i][0] = sour;
            ingredient[i][1] = bitter;
        }


        //재료를 조합해서 신맛과 쓴맛의 차이가 가장 작은 경우의 수를 출력한다
        recursion(0, 1, 0, 0);

        System.out.println(answer);
    }

    private static void recursion(int index, int sour, int bitter, int use) {

        if(index == N){
            //재료는 무조건 하나 이상 사용해야한다
            if(use == 0){
                return;
            }

            int result = Math.abs(sour - bitter);

            if(result <= answer){
                answer = result;
            }

            return;
        }

        //신맛 S 은 곱하기
        //쓴맛 B 은 더하기
        //해당 재료를 사용하는 경우
        recursion(index+1, sour * ingredient[index][0], bitter + ingredient[index][1], use + 1);

        //해당 재료를 사용하지 않는 경우
        recursion(index+1, sour, bitter, use);

    }

}