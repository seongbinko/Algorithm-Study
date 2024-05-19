package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

    static int N;
    static Interview[] interviews;
    static int maxPrice = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //남은 일수
        interviews = new Interview[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            interviews[i] = new Interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recursion(1, 0);
        System.out.println(maxPrice);

    }

    private static void recursion(int index, int sumPrice) {

        //퇴사 당일인 경우
        if(N+1 == index){
            //최대값 확인
            if(maxPrice <= sumPrice){
                maxPrice = sumPrice;
            }
            return;
        }

        //상담했을 때 퇴사 이후 날짜에 끝나는 경우
        if(N+1 < index){ //8 < index
            return;
        }

        //상담 함
        //다음 상담일로 이동, 오늘 상담금액 추가
        recursion(index + interviews[index].getDay(), sumPrice + interviews[index].getPrice());
        //recursion(7, 5일까지 일한 돈)
        //상담함 케이스 : recursion(9, 7일까지 일한 돈) 받을 수 없으므로 return;
        //상담안함 케이스 : recursion(8, 5일까지 일한 돈)

        //상담 안함
        recursion(index+1, sumPrice);


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