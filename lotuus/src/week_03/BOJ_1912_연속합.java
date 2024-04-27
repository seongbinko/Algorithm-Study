package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

    /*
    n개의 정수로 이루어진 임의의 수열이 주어진다.
    우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
    단, 수는 한 개 이상 선택해야 한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        //누적합 배열 만들기
        int[] prefix = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            //현재 입력되는 수
            int current = Integer.parseInt(st.nextToken());

            //현재 입력되는 수와 누적합을 계산한 수
            int prefixValue = prefix[i] + current;

            //최적화
            //current > prdfixValue인 경우 현재 입력되는 수부터 누적합을 다시 계산하면 된다.
            if(current > prefixValue){
                prefix[i+1] = current;
            }else{
                prefix[i+1] = prefixValue;
            }

            //최대값 구하기
            if(max < prefix[i+1]){
                max = prefix[i+1];
            }

        }


        System.out.println(max);

    }

}
