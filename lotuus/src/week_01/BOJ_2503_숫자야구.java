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
                for (int c = 1; c <= 9; c++) { //1의 자리수

                    //같은 숫자로 이루어진 세자리수는 아님. 제외
                    if( a==b || b==c || c==a ){
                        continue;
                    }

                    int passCnt = 0; //힌트통과 수

                    //정답과 질문한 숫자비교
                    for (int i = 0; i < cases; i++) {
                        String hint = String.valueOf(hints[i][0]);
                        int inputStrike = hints[i][1];
                        int inputBall = hints[i][2];

                        //hint x y z 쪼개기
                        int x = hint.charAt(0) - '0';
                        int y = hint.charAt(1) - '0';
                        int z = hint.charAt(2) - '0';

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
                        if(strike == inputStrike && ball == inputBall){
                            passCnt++; //힌트를 하나 통과했다
                        }

                        //영수가 질문한 모든 답에 해당. 정답일 가능성이 있는 숫자이다.
                        if(passCnt == cases){
                            //System.out.println(a+""+b+""+c);
                            result++;
                        }
                    }


                }
            }
        }

        System.out.println(result);

    }


    /*
    정답 : 서로 다른 숫자 세개로 구성된 세 자리수
    스트라이크 : 정답 숫자들 중에 동일한 수, 동일한 자리에 위치하는 경우
    볼 : 정답 숫자들 중에 동일한 수, 다른 자리에 위치하는 경우

    풀이
    정답 범위 : 123~987
    왜냐면, 서로 다른 숫자들이기 때문

    정답이 123인 경우,
        질문 123에 대해서 스트라이크 3개, 볼 0개가 나온다. 질문의 답인 스트라이크 1개, 볼 1개와 다르기 때문에 123은 정답이 아니다.

    정답이 124인 경우,
        질문 123에 대해서 스트라이크 2개, 볼 0개가 나온다. 질문의 답인 스트라이크 1개, 볼 1개와 다르기 때문에 123은 정답이 아니다.

    ...

    정답이 ???인 경우,
        질문 123에 대해서 스트라이크 1개, 볼 1개가 나온다. 질문의 답과 동일하기 때문에 ???은 정답이 될 수 있다.
        질문 356에 대해서 스트라이크 1개, 볼 0개가 나온다. 질문의 답과 동일하기 때문에 ???은 정답이 될 수 있다.
        ..
        ..

        영수가 질문한 모든 답에 해당된다면 정답일 가능성이 있는 숫자이다.

    * */

}
