package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2436_공약수공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long GCD = Long.parseLong(st.nextToken());
        long LCM = Long.parseLong(st.nextToken());

        //gcd와 lcm을 가진 두개의 자연수를 구하시오
        //자연수가 여러개인 경우엔, 두 자연수의 합이 최소가 되는 두 수를 출력
        //lcm = a * b / GCD
        long ab = LCM * GCD; //a * b
        long sum = Long.MAX_VALUE;
        long resultA = 0;
        long resultB = 0;

        for (long a = GCD; a <= (long) Math.sqrt(ab) + 1; a++) {

            long b = ab / a;

            //최대공약수에 해당되는지 확인
            if(GCD(a, b) == GCD){

                //최소공배수에 해당되는지 확인
                if(LCM(a, b) == LCM){

                    //두 자연수의 합이 최소인지 확인
                    if(sum > a + b){
                        sum = a + b;
                        resultA = a;
                        resultB = b;
                    }

                }
            }
        }

        System.out.println(resultA + " " + resultB);

    }

    public static long GCD(long a, long b){
        while ( a % b != 0 ){ //나머지가 없어지는 순간 멈춘다
            //나머지 계산
            long temp = a % b;

            //위치바꾸기
            a = b;
            b = temp;
        }
        return b;
    }

    public static long LCM(long a, long b){
        return (a * b) / GCD(a, b);
    }

    /*
    공약수
    두 수의 공통적인 약수

    GCD(8, 12) == GCD(12-8, 8)
    GCD(A, B) == GCD(B-A, A)

    최대공약수
    공약수 중 가장 큰 수

    두 수 중 하나로 나누어서 나머지가 생기지 않는다면, 작은 수가 바로 최대공약수이다.
    12 % 8 == 4 //나머지가 생김. 8은 최대공약수가 아님
    8 % 4 == 0 //나머지가 없음. 4는 8과 4의 최대공약수!

    공배수
    두 수의 공통적인 배수

    최소공배수
    공배수 중 가장 작은 수
    a * b / GCD

    * */
}
