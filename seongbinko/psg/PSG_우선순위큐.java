package psg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PSG_우선순위큐 {
    public static void main(String[] args) {
        PSG_우선순위큐 q = new PSG_우선순위큐();
        System.out.println(q.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
    }

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int sc : scoville) {
            pq.offer(sc);
        }
        int count = 0;
        while (count <= scoville.length - 2 && !pq.isEmpty()) {
            if (pq.peek() < K) {
                int i = pq.poll();
                int j = pq.poll();
                pq.offer(i + (2 * j));
                count++;
            } else {
                break;
            }
        }
        return pq.peek() < K ? -1 : count;
    }
}
