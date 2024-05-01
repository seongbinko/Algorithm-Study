package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_재귀_중복불가_오름차순 {

    /*
        중복되는 수열 출력하면 안됨
        출력되는 숫자는 오름차순으로 증가되어야 함
    * */

    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursion(0, new boolean[N+1], "");
    }

    private static void recursion(int cnt, boolean[] input, String output) {

        if(cnt == M){
//            System.out.println(" ".repeat(cnt) +"[cnt == M] print output >> " + output);
            System.out.println(output);
            return;
        }

        for (int num = 1; num <= N; num++) {

            //이미 입력된 수라면 다음 수로
            if(input[num]){
                continue;
            }

            for (int i = 0; i <= num; i++) {
                input[i] = true; //입력 수 체크
            }
//            System.out.println(" ".repeat(cnt) +"[before recur] cnt = " + cnt + ", num = " + num + ", input = " + Arrays.toString(input) + ", output = " + output);

            recursion(cnt+1, input, output + num + " ");

            for (int i = num; i <= N; i++) {
                input[i] = false; //입력 수 해제
            }
//            System.out.println(" ".repeat(cnt) +"[_after recur] cnt = " + cnt + ", num = " + num + ", input = " + Arrays.toString(input) + ", output = " + output);
        }


    }

}

