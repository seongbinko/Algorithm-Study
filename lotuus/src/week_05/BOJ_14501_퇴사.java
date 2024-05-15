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
        interviews = new Interview[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            interviews[i] = new Interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recursion(0, 0);
        System.out.println(maxPrice);

    }

    private static void recursion(int index, int sumPrice) {

        //회사에 없는 날짜인경우
        if(N == index){

            //최대값 확인
            if(maxPrice <= sumPrice){
                maxPrice = sumPrice;
            }

            return;
        }

        //상담 가능 여부 확인
        int nextIndex = index + interviews[index].getDay();
        if(nextIndex <= N){

            //상담 가능
            recursion(nextIndex, sumPrice + interviews[index].getPrice());

        }

        //상담 가능여부와 상관없이 상담 안함
        //상담 불가
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