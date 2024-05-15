package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_냅색 {

    static int N;
    static int maxWeight;
    static Item[] items;
    static int maxValue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물품 수
        maxWeight = Integer.parseInt(st.nextToken()); //준서가 버틸 수 있는 무게
        items = new Item[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recursion(0, 0, 0);
        System.out.println(maxValue);

    }

    private static void recursion(int index, int sumWeight, int sumValue) {

        //물건을 모두 확인했다면 중지
        if(index == N){

            //value 최대값 체크
            if(maxValue < sumValue){
                maxValue = sumValue;
            }
            return;
        }

        //가방에 물건을 넣을 수 있는지 확인. 물건을 넣었을 때 무게 체크
        int nextItemWeight = sumWeight + items[index].getWeight();
        if(nextItemWeight <= maxWeight){

            //물건을 넣고
            //다음물건 탐색
            recursion(index+1, nextItemWeight, sumValue + items[index].getValue());

        }

        //물건을 넣지 않는 경우
        recursion(index+1, sumWeight, sumValue);

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