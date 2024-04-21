package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15736_제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.sqrt(N));
    }

    /*
    N개의 초록색 조명
    버튼을 눌러서 초록 > 빨강 > 초록으로 변경 가능
    1부터 N명까지 학생들이 나와서 자신의 순서의 배수에 해당하는 조명에 버튼을 눌러 색 변경 가능
    N명이 모두 버튼을 눌렀을 때, 마지막에 남은 빨간 조명의 개수는?

    1부터 10까지 돌려보면 제곱수에 해당하는 수만 빨간색으로 남게됨.
    * */


}
