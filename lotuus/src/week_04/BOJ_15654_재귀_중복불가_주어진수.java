package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_재귀_중복불가_주어진수 {

    static int N = 0;
    static int M = 0;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(number);

        StringBuilder sb = new StringBuilder();

        recursion(0, new int[N], new boolean[N], sb);
        System.out.println(sb);
    }

    private static void recursion(int cnt, int[] input, boolean[] check, StringBuilder output) {

        if(cnt == M){
            for (int i = 0; i < M; i++) {
                 output.append(input[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            int num = number[i];

            if(check[i]){
                continue;
            }

            input[cnt] = num;
            check[i] = true;

            recursion(cnt+1, input, check, output);

            check[i] = false;
        }

    }

}

