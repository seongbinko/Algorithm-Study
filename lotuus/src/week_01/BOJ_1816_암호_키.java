package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1816_암호_키 {

    public static void main(String[] args) throws IOException {

        //S의 모든 소인수가 10^6보다 크다면 YES
        //반대로 말하면, 2 ~ 10^6 사이의 약수를 가지고 있다면 NO
        //소인수 = 약수 중 소수인 것들

        //테스트케이스 : N개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < testcases; testcase++) {
            //어떤 수 S가 주어진다
            long s = Long.parseLong(br.readLine());

            //결과값
            String result = "YES";

            for (long i = 2; i <= 1000000; i++) {

                if(s % i == 0){
                    result = "NO";
                    break;
                }

            }

            System.out.println(result);
        }

        br.close();

    }


}
