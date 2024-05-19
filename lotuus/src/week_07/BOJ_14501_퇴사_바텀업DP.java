package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사_바텀업DP {

    static int N;
    static Interview[] interviews;
    static int[] dp; //받을 수 있는 금액 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //남은 일수
        interviews = new Interview[N+1];
        dp = new int[N+1];
        Arrays.fill(dp, -1); //-1인 이유 : 받을 수 있는 금액이 0일수도 있으니까

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            interviews[i] = new Interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        for (int index = N-1; index >= 0; index--) {
            int nextIndex = index + interviews[index].getDay();

            //DP 범위를 벗어났다면
            if(N < nextIndex){

                dp[index] = dp[index+1];

            }else{

                //상담 함. 다음 상담일로 이동
                //그리고!! 상담했으니까 돈 추가
                int workPrice = dp[nextIndex] + interviews[index].getPrice();

                //상담 안함
                int noWorkPrice = dp[index+1];

                //DP테이블에 결과 저장. index(날짜)별로 max(상담 했을 때, 상담 안했을 때)값
                dp[index] = Math.max(workPrice, noWorkPrice);

            }
        }

        System.out.println(dp[0]);

    }


    private static class Interview {
        private int day;
        private int price;

        public int getDay() {
            return day;
        }

        public int getPrice() {
            return price;
        }

        public Interview(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }
}