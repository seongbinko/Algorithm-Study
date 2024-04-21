package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO 틀렸습니다!!
public class BOJ_2503_숫자야구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        int[][] hints = new int[cases][3];
        int result = 0;

        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hints[i][0] = Integer.parseInt(st.nextToken());
            hints[i][1] = Integer.parseInt(st.nextToken());
            hints[i][2] = Integer.parseInt(st.nextToken());
        }


        //A가 생각하고있는 수
        for (int a = 1; a <= 9; a++) { //100의 자리수
            for (int b = 1; b <= 9; b++) { //10의 자리수
                for (int c = 1; c < 9; c++) { //1의 자리수

                    //같은 숫자로 이루어진 세자리수는 아님. 제외
                    if( a==b || b==c || c==a ){
                        continue;
                    }

                    int cnt = 0; //힌트통과 수 ?????????????????????????


                    //숫자비교
                    for (int i = 0; i < cases; i++) {
                        String hint = String.valueOf(hints[i][0]);
                        int inputStrike = hints[i][1];
                        int inputBall = hints[i][2];

                        //hint x y z 쪼개기
                        int x = hint.charAt(0) - '0';
                        int y = hint.charAt(1) - '0';
                        int z = hint.charAt(2) - '0';

                        int ball = 0;
                        int strike = 0;

                        //숫자가 a, b, c 중에 있는 경우
                        //strike는 따로 계산하니 각각 다른 자리수를 체크해야함!!
                        boolean aBall = a==y || a==z;
                        if(aBall){
                            ball++;
                        }
                        boolean bBall = b==x || b==z;
                        if(bBall){
                            ball++;
                        }
                        boolean cBall = c==x || c==y;
                        if(cBall){
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
                        if(ball == inputBall && strike == inputStrike){
                            cnt++; //힌트를 하나 통과했다
                        }

                        if(cnt == cases){
                            result++;
                        }
                    }

                }
            }
        }

        System.out.println(result);

    }
}
