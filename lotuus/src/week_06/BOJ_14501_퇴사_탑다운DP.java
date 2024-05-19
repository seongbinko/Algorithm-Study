package week_06;

import week_05.BOJ_14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사_탑다운DP {

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

        int maxPrice = recursion(1);
        System.out.println(maxPrice);

    }

    private static int recursion(int index) {

        //퇴사 당일인 경우
        if(N+1 == index){
            return 0;
        }

        //상담 했을 때 퇴사 이후 날짜에 끝나는 경우
        if(N+1 < index){ //8 < index
            //돈 못받으니까 0
            return Integer.MIN_VALUE; //0이면 마지막날이 계산됨 근데 왜..?
        }

        //만약 이미 저장된 값이라면 불러오기
        if(dp[index] != -1){
            return dp[index];
        }


        //상담 함. 다음 상담일로 이동
        //그리고!! 상담했으니까 돈 추가
        int workPrice = recursion(index + interviews[index].getDay()) + interviews[index].getPrice();

        //상담 안함
        int noWorkPrice = recursion(index+1);

        //DP테이블에 결과 저장. index(날짜)별로 max(상담 했을 때, 상담 안했을 때)값
        dp[index] = Math.max(workPrice, noWorkPrice);
        //
        //index = 1, workPrice = recursion(1+3) + 10
            //index = 4, workPrice = recursion(4+1) + 20
                //index = 5, workPrice = recursion(5+2) + 15
                    //index = 7, workPrice = recursion(7+2) // N+1 < index, return 0;
                //index = 5, noWorkPrice = recursion(5+1) //return dp[6]
                    //index = 6, workPrice = recursion(6+4) //return 0;
                    //index = 6, noWorkPrice = recursion(6+1)
                        //index = 7, workPrice = recursion(7+2) //return 0;
                        //index = 8, noWorkPrice = recursion(8) //return 0;
                    //index = 6, dp[6] = max(0, 0)
                //index = 5, dp[5] = max(15, 0)
            //index = 4, noWorkPrice = recursion(4+1) //return dp[5]
            //index = 4, dp[4] = max(0+15+20, 15)


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