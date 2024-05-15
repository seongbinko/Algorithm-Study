package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_냅색_DP {

    static int N;
    static int maxWeight;
    static Item[] items;

    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물품 수
        maxWeight = Integer.parseInt(st.nextToken()); //준서가 버틸 수 있는 무게
        items = new Item[N];

        dp = new int[N][100001];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int maxValue = recursion(0, 0);
        System.out.println(maxValue);

    }

    private static int recursion(int index, int sumWeight) {

        //물건의 총 합이 Max보다 크다면 물건 더이상 못넣음
        if(maxWeight < sumWeight){
            return Integer.MIN_VALUE;
        }

        //물건을 모두 확인했다면 중지
        if(index == N){
            return 0;
        }


        if(dp[index][sumWeight] != -1){
            return dp[index][sumWeight];
        }

        //물건을 넣고
        //다음물건 탐색
        int put = recursion(index+1, sumWeight + items[index].getWeight()) + items[index].getValue();

        //물건을 넣지 않는 경우
        int noput = recursion(index+1, sumWeight);


        dp[index][sumWeight] = Math.max(put, noput);

        return dp[index][sumWeight];

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