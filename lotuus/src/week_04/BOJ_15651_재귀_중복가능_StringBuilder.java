package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_재귀_중복가능_StringBuilder {

    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //시간초과 방지
        StringBuilder sb = new StringBuilder();

        recursion(0, new int[N+1], sb);
        System.out.println(sb);
    }

    private static void recursion(int cnt, int[] input, StringBuilder output) {

        if(cnt == M){
            for (int i = 0; i < M; i++) {
                 output.append(input[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int num = 1; num <= N; num++) {
            input[cnt] = num;
            recursion(cnt+1, input, output);
        }


    }

}

