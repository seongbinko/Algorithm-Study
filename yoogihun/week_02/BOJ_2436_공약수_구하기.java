package week_02;

import java.util.Scanner;

public class BOJ_2436_공약수_구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //A,B가 주어졌을때 A와 B의 최대공약수, 최소공배수 구하기
        //갭을 줄이고, 하나의수를 작은수가 되는만큼 뺀다 = 나머지 구하기
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int gcd = gcd(a,b);
        int lcm = lcm(a,b);
        System.out.println(gcd);
        System.out.println(lcm);
        //입력한 값을 최대공약수, 최소 공배수로 사용하는 자연수 쌍을 구하라.
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b); // a*b/b = 30*36/36
    }

    private static int gcd(int a, int b) {
        while (a % b != 0) {
            int tmp = a%b;
            //a에는 b를 담아준다.
            a = b;
            //나머지 수를 b에 담음
            b = tmp;
        }
        return b;
    }
}
