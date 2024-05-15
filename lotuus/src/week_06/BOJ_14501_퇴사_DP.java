package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사_DP {

    static int N;
    static Interview[] interviews;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //남은 일수
        interviews = new Interview[N];
        dp = new int[N+1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            interviews[i] = new Interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int maxPrice = recursion(0);
        System.out.println(maxPrice);

    }

    private static int recursion(int index) {

        //퇴사 이후 날짜인 경우
        if(N == index){
            return 0; //상담해서 받는 돈 없음
        }

        if(index > N){
            return Integer.MIN_VALUE;
        }

        //이미 저장되었다면
        if(dp[index] != -1){
            return dp[index];
        }

        //상담 가능하니 가격을 넣고
        //다음 가능한 날짜 탐색
        int nextIndex = index + interviews[index].getDay();
        int workPrice = recursion(nextIndex) + interviews[index].getPrice();

        //상담 가능여부와 상관없이 상담 안함
        //상담 불가
        int noWorkPrice = recursion(index+1);

        //index에 해당하는 날짜에 더 많은 돈을 버는 경우의 수를 저장
        dp[index] = Math.max(workPrice, noWorkPrice);

        return dp[index];
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