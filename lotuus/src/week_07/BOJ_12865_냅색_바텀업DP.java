package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_냅색_바텀업DP {

    static int N;
    static int maxWeight;
    static Item[] items;

    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물품 수
        maxWeight = Integer.parseInt(st.nextToken()); //준서가 버틸 수 있는 무게
        items = new Item[N+1];

        dp = new int[N+1][maxWeight+1];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, 0);
//        }


        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        for (int index = 1; index < N+1; index++) {
            for (int sumWeight = 0; sumWeight <= maxWeight; sumWeight++) {

                if(sumWeight < items[index].getWeight()){
                    dp[index][sumWeight] = dp[index-1][sumWeight];
                }else {

                    //물건을 넣고
                    //다음물건 탐색
                    int put = dp[index-1][sumWeight - items[index].getWeight()] + items[index].getValue();

                    //물건을 넣지 않는 경우
                    int noput = dp[index-1][sumWeight];


                    dp[index][sumWeight] = Math.max(put, noput);
                }
            }
        }

        System.out.println(dp[N][maxWeight]);


    }


    private static class Item {
        private int weight;
        private int value;

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}