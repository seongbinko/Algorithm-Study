package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_재귀_중복되는수열출력안함 {

    /*
        중복되는 수열 출력하면 안됨
    * */

    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //M == 4
        recursion(0, "");

    }

    private static void recursion(int input, String output) {
        if(input == M){
            System.out.println(output);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(i == input){
                continue;
            }
            recursion(input+1, output + i + " ");
        }

        //input=0, i=1, recursion(1, "1 ")
            //input=1, i=1, recursion(2, "1 1 ")
                //input=2, i=1, recursion(3, "1 1 1 ")
                    //sout
                //input=2, i=2, recursion(3, "1 1 2 ")
                    //sout
                //input=2, i=3, recursion(3, "1 1 3 ")
                    //sout
                //input=2, i=4, recursion(3, "1 1 4 ")
                    //sout
            //input=1, i=2, recursion(2, "1 2 ")
                //input=2, i=1, recursion(3, "1 2 1 ")
        ///...


    }




}
