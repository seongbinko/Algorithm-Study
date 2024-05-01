package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649_재귀_중복불가 {

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

        recursion(0, "", new boolean[N+1]);

    }

    private static void recursion(int cnt, String output, boolean[] numberPossible) {
        //글자 개수 다 채워졌는지 확인
        if(cnt == M){
            System.out.print(" ".repeat(cnt) + "[______cnt==M] cnt : " + cnt + ", num : ?, arr : "+ Arrays.toString(numberPossible)+", output : " + output);
            System.out.println(" ".repeat(cnt) + ">>>>> " + output);
            return;
        }

        //입력하는 숫자
        for (int num = 1; num <= N; num++) {

            //인덱스에 해당하는 숫자가 나왔으면 다음숫자
            if(numberPossible[num]){
                continue;
            }

            //인덱스에 해당하는 숫자가 선점처리
            numberPossible[num] = true;

            System.out.println(" ".repeat(cnt) + "[before recur] cnt : " + cnt + ", num : "+ num +", arr : "+Arrays.toString(numberPossible)+", output : " + output);
            recursion(cnt+1, output + num + " ", numberPossible);

            //가장 안쪽 재귀에서 4자리 모두 채운 후에 실행되는 코드
            //이전 재귀들에서 경우의 수를 또 체크하려면, 해지해주어야함.
            numberPossible[num] = false;
            System.out.println(" ".repeat(cnt) + "[_after recur] cnt : " + cnt + ", num : "+ num +", arr : "+Arrays.toString(numberPossible)+", output : " + output);

        }

    }

}


/*

4 4
[before recur] cnt : 0, num : 1, arr : [false, true, false, false, false], output :
 [before recur] cnt : 1, num : 2, arr : [false, true, true, false, false], output : 1
  [before recur] cnt : 2, num : 3, arr : [false, true, true, true, false], output : 1 2
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 1 2 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 2 3 4     >>>>> 1 2 3 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 1 2 3
  [_after recur] cnt : 2, num : 3, arr : [false, true, true, false, false], output : 1 2
  [before recur] cnt : 2, num : 4, arr : [false, true, true, false, true], output : 1 2
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 1 2 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 2 4 3     >>>>> 1 2 4 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 1 2 4
  [_after recur] cnt : 2, num : 4, arr : [false, true, true, false, false], output : 1 2
 [_after recur] cnt : 1, num : 2, arr : [false, true, false, false, false], output : 1
 [before recur] cnt : 1, num : 3, arr : [false, true, false, true, false], output : 1
  [before recur] cnt : 2, num : 2, arr : [false, true, true, true, false], output : 1 3
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 1 3 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 3 2 4     >>>>> 1 3 2 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 1 3 2
  [_after recur] cnt : 2, num : 2, arr : [false, true, false, true, false], output : 1 3
  [before recur] cnt : 2, num : 4, arr : [false, true, false, true, true], output : 1 3
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 1 3 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 3 4 2     >>>>> 1 3 4 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 1 3 4
  [_after recur] cnt : 2, num : 4, arr : [false, true, false, true, false], output : 1 3
 [_after recur] cnt : 1, num : 3, arr : [false, true, false, false, false], output : 1
 [before recur] cnt : 1, num : 4, arr : [false, true, false, false, true], output : 1
  [before recur] cnt : 2, num : 2, arr : [false, true, true, false, true], output : 1 4
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 1 4 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 4 2 3     >>>>> 1 4 2 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 1 4 2
  [_after recur] cnt : 2, num : 2, arr : [false, true, false, false, true], output : 1 4
  [before recur] cnt : 2, num : 3, arr : [false, true, false, true, true], output : 1 4
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 1 4 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 1 4 3 2     >>>>> 1 4 3 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 1 4 3
  [_after recur] cnt : 2, num : 3, arr : [false, true, false, false, true], output : 1 4
 [_after recur] cnt : 1, num : 4, arr : [false, true, false, false, false], output : 1
[_after recur] cnt : 0, num : 1, arr : [false, false, false, false, false], output :
[before recur] cnt : 0, num : 2, arr : [false, false, true, false, false], output :
 [before recur] cnt : 1, num : 1, arr : [false, true, true, false, false], output : 2
  [before recur] cnt : 2, num : 3, arr : [false, true, true, true, false], output : 2 1
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 2 1 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 1 3 4     >>>>> 2 1 3 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 2 1 3
  [_after recur] cnt : 2, num : 3, arr : [false, true, true, false, false], output : 2 1
  [before recur] cnt : 2, num : 4, arr : [false, true, true, false, true], output : 2 1
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 2 1 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 1 4 3     >>>>> 2 1 4 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 2 1 4
  [_after recur] cnt : 2, num : 4, arr : [false, true, true, false, false], output : 2 1
 [_after recur] cnt : 1, num : 1, arr : [false, false, true, false, false], output : 2
 [before recur] cnt : 1, num : 3, arr : [false, false, true, true, false], output : 2
  [before recur] cnt : 2, num : 1, arr : [false, true, true, true, false], output : 2 3
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 2 3 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 3 1 4     >>>>> 2 3 1 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 2 3 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, true, true, false], output : 2 3
  [before recur] cnt : 2, num : 4, arr : [false, false, true, true, true], output : 2 3
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 2 3 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 3 4 1     >>>>> 2 3 4 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 2 3 4
  [_after recur] cnt : 2, num : 4, arr : [false, false, true, true, false], output : 2 3
 [_after recur] cnt : 1, num : 3, arr : [false, false, true, false, false], output : 2
 [before recur] cnt : 1, num : 4, arr : [false, false, true, false, true], output : 2
  [before recur] cnt : 2, num : 1, arr : [false, true, true, false, true], output : 2 4
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 2 4 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 4 1 3     >>>>> 2 4 1 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 2 4 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, true, false, true], output : 2 4
  [before recur] cnt : 2, num : 3, arr : [false, false, true, true, true], output : 2 4
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 2 4 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 2 4 3 1     >>>>> 2 4 3 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 2 4 3
  [_after recur] cnt : 2, num : 3, arr : [false, false, true, false, true], output : 2 4
 [_after recur] cnt : 1, num : 4, arr : [false, false, true, false, false], output : 2
[_after recur] cnt : 0, num : 2, arr : [false, false, false, false, false], output :
[before recur] cnt : 0, num : 3, arr : [false, false, false, true, false], output :
 [before recur] cnt : 1, num : 1, arr : [false, true, false, true, false], output : 3
  [before recur] cnt : 2, num : 2, arr : [false, true, true, true, false], output : 3 1
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 3 1 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 1 2 4     >>>>> 3 1 2 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 3 1 2
  [_after recur] cnt : 2, num : 2, arr : [false, true, false, true, false], output : 3 1
  [before recur] cnt : 2, num : 4, arr : [false, true, false, true, true], output : 3 1
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 3 1 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 1 4 2     >>>>> 3 1 4 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 3 1 4
  [_after recur] cnt : 2, num : 4, arr : [false, true, false, true, false], output : 3 1
 [_after recur] cnt : 1, num : 1, arr : [false, false, false, true, false], output : 3
 [before recur] cnt : 1, num : 2, arr : [false, false, true, true, false], output : 3
  [before recur] cnt : 2, num : 1, arr : [false, true, true, true, false], output : 3 2
   [before recur] cnt : 3, num : 4, arr : [false, true, true, true, true], output : 3 2 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 2 1 4     >>>>> 3 2 1 4
   [_after recur] cnt : 3, num : 4, arr : [false, true, true, true, false], output : 3 2 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, true, true, false], output : 3 2
  [before recur] cnt : 2, num : 4, arr : [false, false, true, true, true], output : 3 2
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 3 2 4
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 2 4 1     >>>>> 3 2 4 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 3 2 4
  [_after recur] cnt : 2, num : 4, arr : [false, false, true, true, false], output : 3 2
 [_after recur] cnt : 1, num : 2, arr : [false, false, false, true, false], output : 3
 [before recur] cnt : 1, num : 4, arr : [false, false, false, true, true], output : 3
  [before recur] cnt : 2, num : 1, arr : [false, true, false, true, true], output : 3 4
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 3 4 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 4 1 2     >>>>> 3 4 1 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 3 4 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, false, true, true], output : 3 4
  [before recur] cnt : 2, num : 2, arr : [false, false, true, true, true], output : 3 4
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 3 4 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 3 4 2 1     >>>>> 3 4 2 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 3 4 2
  [_after recur] cnt : 2, num : 2, arr : [false, false, false, true, true], output : 3 4
 [_after recur] cnt : 1, num : 4, arr : [false, false, false, true, false], output : 3
[_after recur] cnt : 0, num : 3, arr : [false, false, false, false, false], output :
[before recur] cnt : 0, num : 4, arr : [false, false, false, false, true], output :
 [before recur] cnt : 1, num : 1, arr : [false, true, false, false, true], output : 4
  [before recur] cnt : 2, num : 2, arr : [false, true, true, false, true], output : 4 1
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 4 1 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 1 2 3     >>>>> 4 1 2 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 4 1 2
  [_after recur] cnt : 2, num : 2, arr : [false, true, false, false, true], output : 4 1
  [before recur] cnt : 2, num : 3, arr : [false, true, false, true, true], output : 4 1
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 4 1 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 1 3 2     >>>>> 4 1 3 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 4 1 3
  [_after recur] cnt : 2, num : 3, arr : [false, true, false, false, true], output : 4 1
 [_after recur] cnt : 1, num : 1, arr : [false, false, false, false, true], output : 4
 [before recur] cnt : 1, num : 2, arr : [false, false, true, false, true], output : 4
  [before recur] cnt : 2, num : 1, arr : [false, true, true, false, true], output : 4 2
   [before recur] cnt : 3, num : 3, arr : [false, true, true, true, true], output : 4 2 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 2 1 3     >>>>> 4 2 1 3
   [_after recur] cnt : 3, num : 3, arr : [false, true, true, false, true], output : 4 2 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, true, false, true], output : 4 2
  [before recur] cnt : 2, num : 3, arr : [false, false, true, true, true], output : 4 2
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 4 2 3
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 2 3 1     >>>>> 4 2 3 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 4 2 3
  [_after recur] cnt : 2, num : 3, arr : [false, false, true, false, true], output : 4 2
 [_after recur] cnt : 1, num : 2, arr : [false, false, false, false, true], output : 4
 [before recur] cnt : 1, num : 3, arr : [false, false, false, true, true], output : 4
  [before recur] cnt : 2, num : 1, arr : [false, true, false, true, true], output : 4 3
   [before recur] cnt : 3, num : 2, arr : [false, true, true, true, true], output : 4 3 1
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 3 1 2     >>>>> 4 3 1 2
   [_after recur] cnt : 3, num : 2, arr : [false, true, false, true, true], output : 4 3 1
  [_after recur] cnt : 2, num : 1, arr : [false, false, false, true, true], output : 4 3
  [before recur] cnt : 2, num : 2, arr : [false, false, true, true, true], output : 4 3
   [before recur] cnt : 3, num : 1, arr : [false, true, true, true, true], output : 4 3 2
    [______cnt==M] cnt : 4, num : ?, arr : [false, true, true, true, true], output : 4 3 2 1     >>>>> 4 3 2 1
   [_after recur] cnt : 3, num : 1, arr : [false, false, true, true, true], output : 4 3 2
  [_after recur] cnt : 2, num : 2, arr : [false, false, false, true, true], output : 4 3
 [_after recur] cnt : 1, num : 3, arr : [false, false, false, false, true], output : 4
[_after recur] cnt : 0, num : 4, arr : [false, false, false, false, false], output :


* */



