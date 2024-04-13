package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14568_사탕 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candy = Integer.parseInt(br.readLine());
        int cases = 0; //조건을 만족하는 경우의 수

        for (int A = 1; A < candy; A++) {

            for (int B = 1; B < candy; B++) {

                for (int C = 1; C < candy; C++) {

                    if(A + B + C == candy){

                        //A : 받았을 때 짝수개라면 받을 수 있음
                        if( (A + 1) % 2 == 0 ){

                            //C : B + 2 < C 만족하면 받을 수 있음
                            if( B+2 < C ){

                                cases++;

                            }

                        }

                    }

                }

            }

        }

        System.out.println(cases);
    }

}

