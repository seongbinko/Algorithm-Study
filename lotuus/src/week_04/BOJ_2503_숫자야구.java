package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구 {

    static int cases = 0;
    static int answer = 0;

    static int[][] hints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cases = Integer.parseInt(br.readLine());

        hints = new int[cases][3];

        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hints[i][0] = Integer.parseInt(st.nextToken());
            hints[i][1] = Integer.parseInt(st.nextToken());
            hints[i][2] = Integer.parseInt(st.nextToken());
        }


        recursion(0, 100);

        System.out.println(answer);

    }

    private static void recursion(int hintindex, int number) {
        if(hintindex == cases){
            answer = answer + 1;
            recursion(0, number+1);
            return;
        }

        if(number == 1000){
            return;
        }

        //number쪼개기
        int a = String.valueOf(number).charAt(0) - '0';
        int b = String.valueOf(number).charAt(1) - '0';
        int c = String.valueOf(number).charAt(2) - '0';

        //수는 0이 될 수 없음.
        if( a==0 || b==0 || c==0 ){
            recursion(0, number+1);
            return;
        }

        //같은 숫자로 이루어진 세자리수는 아님. 제외
        if( a==b || b==c || c==a ){
            recursion(0, number+1);
            return;
        }

        int x = String.valueOf(hints[hintindex][0]).charAt(0) - '0';
        int y = String.valueOf(hints[hintindex][0]).charAt(1) - '0';
        int z = String.valueOf(hints[hintindex][0]).charAt(2) - '0';

        int strike = 0;
        int ball = 0;

        //숫자가 a, b, c 중에 있는 경우
        //strike는 따로 계산하니 각각 다른 자리수를 체크해야함!!
        if(a==y || a==z){ //a==x 는 스트라이크
            ball++;
        }
        if(b==x || b==z){ //b==y 는 스트라이크
            ball++;
        }
        if(c==x || c==y){ //c==z 는 스트라이크
            ball++;
        }

        //자리수도 동일한 경우
        if( a==x ){
            strike++;
        }
        if( b==y ){
            strike++;
        }
        if( c==z ){
            strike++;
        }

        //계산한 ball, strike값이 주어진 ball, strike값과 동일하다면 경우의 수를 찾은 것
        if(strike == hints[hintindex][1] && ball == hints[hintindex][2]){
            //만약 힌트에 통과했다면
            recursion(hintindex+1, number);

        }else{
            //만약 힌트에 통과하지 않았다면
            recursion(0, number+1);
        }

    }

}

